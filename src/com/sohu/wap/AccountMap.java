/**
 *@version:2012-5-8-下午03:03:50
 *@author:jianjunwei
 *@date:下午03:03:50
 *
 */
package com.sohu.wap;

import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sohu.wap.util.DateUtil;
import com.sohu.wap.util.PropConfigurations;




/**
 * 全局accoutMap 对象 
 * 
 * @author jianjunwei
 *
 */
public class AccountMap {
    
    
    
    private static Logger  log = LoggerFactory.getLogger(AccountMap.class);
    
    
    //单例对象
    private static  AccountMap  _instance;
    
  
    private    ConcurrentHashMap <String , XueYuanAccount>  xueYuanAccountMap   = new ConcurrentHashMap<String, XueYuanAccount> ();
   
    
    private PropConfigurations xueYuan;
    
private    ConcurrentHashMap <String , XueYuanAccount>  scanXueYuanAccountMap   = new ConcurrentHashMap<String, XueYuanAccount> ();
   
    
    private PropConfigurations scanXueYuan;
    
    
    private  AccountMap (){
        init();
    }
    
 
    
    public static AccountMap getInstance(){
        
        if (_instance == null){
            synchronized (AccountMap.class){
                if (_instance == null){
                    _instance  = new AccountMap();
                }
            }
        }
      return   _instance;
    }
    

    
    
 
    
    
  public ConcurrentHashMap  <String , XueYuanAccount>   getXueYuanAccountMap(){
            return xueYuanAccountMap;
    }
  public ConcurrentHashMap  <String , XueYuanAccount>   getScanXueYuanAccountMap(){
      return scanXueYuanAccountMap;
}
  
    
    
    
    
    /**
     * 
     * 初始化 account 对象 
     *
     */
    private  void init (){
        
        
         xueYuan = new PropConfigurations("mapdb.properties");
      
         initXueYuanAccounts();
         
         scanXueYuan = new PropConfigurations("scan.properties");
         
         initScanXueYuanAccounts();
    }
    
    
    
    
    /**
     * 初始化搜狐account 对象 
     */
    private   void initXueYuanAccounts(   ){
     
        
       Properties mapdb =  xueYuan.getProperties();
      
 
        Iterator itor =mapdb.keySet().iterator();
   
        while(itor.hasNext())
        {
            
           XueYuanAccount sa= new XueYuanAccount();
           
           String key = ((String)itor.next()).trim() ;
      
           String value =(String) mapdb.get(key);
        
           String temp [] =  value.split(";");
           
           String password = temp[0];
           String  amPm = temp[1];
           String carType =temp[2];
           if(temp.length > 3){
               String whiteCar = temp[3];
               sa.setWhiteCar(whiteCar);
           }
           
           sa.setUserName(key);
           sa.setPassword(password);
          
           sa.setYueCheAmPm(amPm);
           sa.setCarType(carType);
           
           xueYuanAccountMap.put(key, sa);
//           log.info("add SohuAccounts " + sa);
         }
         
        log.info("initXuYuanAccounts over!" );
    }
    
    /**
     * 初始化 account 对象 
     */
    private   void initScanXueYuanAccounts(   ){
     
        
       Properties mapdb =  scanXueYuan.getProperties();
      
 
        Iterator itor =mapdb.keySet().iterator();
   
        while(itor.hasNext())
        {
           String key = ((String)itor.next()).trim() ;
      
           String value =(String) mapdb.get(key);
        
           String temp [] =  value.split(";");
           
           String userName = temp[0];
           String password = temp[1];

           XueYuanAccount sa= new XueYuanAccount();
           sa.setId(Integer.valueOf(key));
           sa.setUserName(userName);
           sa.setPassword(password);
           sa.setYueCheDate(temp[2]);
           sa.setYueCheAmPm(temp[3]);
           sa.setCarType(temp[4]);
           scanXueYuanAccountMap.put(key, sa);
//           log.info("add SohuAccounts " + sa);
         }
         
        log.info("initScanXuYuanAccounts over!" );
    }
    
    
}
