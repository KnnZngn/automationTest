

package com.myfirstproject;
        import org.junit.Assert;
        import org.junit.Test;
        import java.nio.file.Files;
        import java.nio.file.Paths;
public class Day08_FileExist {
    @Test
    public void isExistTest() {
        //Pick a file on your DESKTOP
        String homeDirectory = System.getProperty("user.home");
        System.out.println(homeDirectory);
        String userDirectory = System.getProperty("user.dir");
        System.out.println(userDirectory);
//        And verify if that file exist on your computer or not
        String filePath = "C:\\Users\\DELL\\Downloads\\logo.jpeg";
        boolean isExist = Files.exists(Paths.get(filePath));// returns true if path exist
        Assert.assertTrue(isExist);//pass if file exist, fails if file doesn't exist
    }
    @Test
    public void isExist1(){
//                Pick a file on your DESKTOP
        String homeDirectory = System.getProperty("user.home");
        System.out.println(homeDirectory);
//        String userDirectory =  System.getProperty("user.dir");
//        System.out.println(userDirectory);
//        String filePath = homeDirectory+"/Desktop/logo.jpeg";//MAC
        String filePath = homeDirectory+"\\Desktop\\logo.jpeg";//WINDOWS
        boolean isExist = Files.exists(Paths.get(filePath));// returns true if path exist
        Assert.assertTrue(isExist);//pass if file exist, fails if file doesn't exist
    }
}


