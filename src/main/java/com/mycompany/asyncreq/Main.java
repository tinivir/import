/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asyncreq;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mycompany.asyncreq.dao.Tdataset;

import com.mycompany.asyncreq.dao.*;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.aspectj.weaver.ast.Var;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.commons.io.FileUtils; 
import static org.json.JSONObject.NULL;

/**
 *
 * @author tiniv_000
 */

public class Main {
    
   
     @SuppressWarnings("empty-statement")
     public static ArrayList<String> GenData()
        {
            
            ArrayList<String> rootobject=new  ArrayList<String>();

           try {
			
			FileInputStream file = new FileInputStream(new File("src/main/resources/Eu3.xlsx"));
                        FileOutputStream ffout=new FileOutputStream(new File("trade.json"));
                        //Get the workbook instance for XLS file 
                        XSSFWorkbook workbook = new XSSFWorkbook (file);

                        //Get first sheet from the workbook
                        XSSFSheet sheet = workbook.getSheetAt(0);
			
			//Iterate through each rows from first sheet
			Iterator rowIterator = sheet.iterator();
                        Root r;
                        String addr;
			while(rowIterator.hasNext()) {
				Row row = (Row) rowIterator.next();
				
				//For each row, iterate through each columns
				Iterator cellIterator = row.cellIterator();
                                
				
					
					Cell cell = (Cell) row.getCell(0);
					
					switch(cell.getCellType()) {

						case Cell.CELL_TYPE_NUMERIC:
                                                    addr="http://comtrade.un.org/api/get?max=50000&type=C&freq=M&px=HS&ps=2014&r=804&p=" + (int)cell.getNumericCellValue() + "&rg=All&cc=All&fmt=json";
                                                    
                                                    
                                                    rootobject.add(addr);
                                                    break;

					
				}

			}
		

			
		} catch (IOException e) {
			e.printStackTrace();
		}


            return rootobject; 
        }


    public static void main(String[ ] args) throws JsonProcessingException, JSONException, IOException
    {

        Configuration config = new Configuration();
        // Name tables with lowercase_underscore_separated
        RestTemplate restTemplate = new RestTemplate();
        config.setNamingStrategy(new ImprovedNamingStrategy());
        try {

 
            ArrayList<String> ArrReq = GenData();
            String addr;
                for(Iterator<String> i = ArrReq.iterator(); i.hasNext(); ) 
                {
                   try{ 
                       addr=i.next();
                       Thread.sleep(1000);
                    Root tRoot=restTemplate.getForObject(addr, Root.class);
                    tRoot.addr=addr;
                    if(!tRoot.dataset.isEmpty())
                    if (tRoot.dataset.size() == tRoot.validation.count.value )
                        ObjToCsv(tRoot,"all");
                    
                    else {
                        for(int reg=1;reg<5;reg++){
                            Thread.sleep(1000);
                            addr="http://comtrade.un.org/api/get?max=50000&type=C&freq=M&px=HS&ps=2014&r=804&p="+tRoot.dataset.get(0).getptCode()+"&rg="+reg+"&cc=All&fmt=json";
                            Root tRootImp=restTemplate.getForObject(addr, Root.class);
                            tRootImp.addr=addr;
                            if(!tRootImp.dataset.isEmpty())
                            if (tRootImp.dataset.size() == tRootImp.validation.count.value )
                                ObjToCsv(tRootImp,Integer.toString(reg));
                            else
                                System.out.println("addr:  "+tRootImp.addr+"\n");
                        }
                    }
                    else System.out.println("addr:  "+tRoot.addr+":null"+"\n");
                   }
                    catch (Exception e) {
                        System.err.println(e.getMessage());
                            
                            }
                }

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    
       public static void ObjToCsv(Root tRoot,String reg) throws IOException 
   {
                               List<Tdataset> arForms = tRoot.dataset;
                        List<ArrayList<String>> tradeDatas = new ArrayList<ArrayList<String>>();


                        int count=0;
                        for(Iterator<Tdataset> j = arForms.iterator(); j.hasNext(); )
                        {

                            Tdataset tmp=j.next();
                             DateFormat format = new SimpleDateFormat("yyyyMM");
                                try{
                                Date date = format.parse(tmp.getperiod());
                                Ttradedata trade=new Ttradedata(tmp.getrtCode(), tmp.getptCode(), tmp.getrgCode(), tmp.getqtCode(), tmp.getestCode(), date, tmp.getTradeQuantity(), tmp.getNetWeight(), tmp.getTradeValue(),tmp.getcmdCode());


                            tradeDatas.add(trade.setString());
                            if(tradeDatas.size()%10000==0)
                            {
                                writeToCSV(tradeDatas,"data/"+tRoot.dataset.get(0).getptCode()+"_"+count+"_"+reg+".csv");
                                count++;
                                tradeDatas.clear();
                            }
                            }
                                catch(Exception e){
                                    System.out.println(e.toString());
                                }
                        }

                        writeToCSV(tradeDatas,"data/"+tRoot.dataset.get(0).getptCode()+"_"+reg+".csv");
                        tradeDatas.clear();
                        System.out.println("ok!");
                    

       
   }

       
           private static void writeToCSV(List<ArrayList<String>> csvInput,String csv) throws IOException{


            CSVWriter writer = null;

            try {
                writer = new CSVWriter(new FileWriter(csv));
                } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                }


            for(ArrayList<String> each: csvInput){
                String[] eachTemp =  each.toArray(new String[each.size()]);
                writer.writeNext( eachTemp);
            }

            writer.close();
            }
    
}
