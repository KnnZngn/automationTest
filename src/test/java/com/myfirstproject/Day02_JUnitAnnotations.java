package com.myfirstproject;

import org.junit.*;

public class Day02_JUnitAnnotations {
/*
@Test is used to create test cases
All test methods should be ***void
We cannot run methods without @Test
@BeforeClass is used to run once before the entire class
@BeforeClass is also used for PRECONDITION
@AfterClass is used to run once after the entire class
@AfterClass is also used for AFTERCONDITION
@Before is used to run before each @Test method
@After is used to run after each @Test method
@Ignore is used to skip/ignore a @Test method
* */
    //void olmasi lazim @test in
    //static olursa run butonu olmaz

    @BeforeClass //ilk once bu calisir CLASS ta ve static olmali yoksa error vrir
    public static void setUpClass(){
        System.out.println("Before Class");
    }
    @AfterClass //En son bu calisir CLASS ta ve static olmali yoksa error vrir
    public static void tearDownClass(){
        System.out.println("After Class");
    }
    @Before //kac method varsa once bu calisir. 4 se 4 10 sa 10 static degil yalnizca void olmali
    public void setUpMethod(){
        System.out.println("Before Method");
    }
    @After //kac method varsa ardindan bu calisir. 4 se 4 10 sa 10 static degil yalnizca void olmali
    public void tearDownMethod(){
        System.out.println("After Method. Reports. Driver close.");
    }
    @Test
    public void test1(){
        System.out.println("Test 1");
    }

    @Test @Ignore
    public void test2(){
        System.out.println("Test 2");
    }

    @Test
    public void test3(){
        System.out.println("Test 3");
    }
    @Test
    public void test4(){
        System.out.println("Test 4");
    }


}
