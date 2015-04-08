/*
 */
package org.schragl.codingtest.api;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.schragl.codingtest.Expense;

/**
 * Testing the web services API of the ExpenseFacadeRESTTest class.
 * 
 * @author dan
 */
public class ExpenseFacadeRESTTest {
    private static final String BASE_URI = "http://localhost:8080/api";

    public ExpenseFacadeRESTTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        //System.out.println("setUpClass(): Testing Webservices API of AlchemyCodingTest: Testing ExpenseFacaceRest Class:\n");
    }

    @AfterClass
    public static void tearDownClass() {
        //System.out.println("tearDownClass(): Tests Done!\n");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    /**
     * Testing create method of class ExpenseFacadeREST.
     * TODO: not working now, causes a Bean Validation constraint(s) violation while calling
     *   public void org.schragl.codingtest.api.ExpenseFacadeREST.create
     */
    //@Test
    private void testCreate(Client client, WebTarget target) {
        if (client == null || target == null) return;
        System.out.println("Calling the create Expense Web Service API");

        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        
        Expense expense = new Expense();
        expense.setDate(today);
        expense.setAmount(60);
        expense.setVat(10);
        expense.setReason("JUnit Test");
        expense.setId(32);

        Response response = target.request().post(Entity.entity(expense, MediaType.APPLICATION_JSON));
//                buildPost(Entity.entity(expense, MediaType.APPLICATION_JSON)).invoke();
//        System.out.println("createExpense(): " + response.getLocation().getPath());
    }
    
//    /**
//     * Testing create method of class ExpenseFacadeREST via EJB lookup.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        Expense expense = new Expense();
//        expense.setAmount(99); expense.setReason("JUnit Test Create"); 
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        ExpenseFacadeREST instance = (ExpenseFacadeREST)container.getContext().lookup("java:global/classes/ExpenseFacadeREST");
//        instance.create(expense);
//        container.close();
//    }
        
    /**
     * Testing count method of class ExpenseFacadeREST.
     */
    //@Test
    private Integer testCount(Client client, WebTarget target) {
        if (client == null || target == null) return -1;
        System.out.println("Calling the count method of the Web Service API");
        Integer count = target.path("count").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(Integer.class);
        assertTrue(count >= 0);
        //System.out.println("Expenses returned by API = " + expense);
        return count;
    }

    /**
     * Testing find method of class ExpenseFacadeREST.
     */
    //@Test
    private Expense testFind(int id, Client client, WebTarget target) {
        if (client == null || target == null) return null;
        System.out.println("Calling the find Expense by ID Web Service API");
        Expense expense = target.path("" +id).request("application/json").get(Expense.class);
        return expense;
    }

    /**
     * Testing edit method of class ExpenseFacadeREST.
     * TODO: not working now, causes a Bean Validation constraint(s) violation while calling
     *   public void org.schragl.codingtest.api.ExpenseFacadeREST.edit
     * 
     */
    //@Test
    private void testEdit(int id, Client client, WebTarget target) {
        if (client == null || target == null) return;
        System.out.println("Calling the edit Expense by ID Web Service API");
        
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        
        Expense expense = new Expense();
        expense.setDate(today);
        expense.setAmount(60);
        expense.setVat(10);
        expense.setReason("JUnit Edit Test");
        expense.setId(id);
        
        Expense updatedExpense = target.path("" +id).request("application/json").put(Entity.entity(expense, MediaType.APPLICATION_JSON), Expense.class);
        assertNotNull(updatedExpense);
        assertTrue(updatedExpense.getAmount() == expense.getAmount());
        assertTrue(updatedExpense.getVat() == expense.getVat());
        assertTrue(updatedExpense.getReason().equals(expense.getReason()));
        //TODO: set the expenses' properties it back to what they were at start of this test
    }

    /**
     * Testing delete method of class ExpenseFacadeREST.
     */
    //@Test
    private void testDelete(int id, Client client, WebTarget target) {
        if (client == null || target == null) return;
        System.out.println("Calling the delete Expense by ID Web Service API");
        Response response = target.path("" +id).request("application/json").delete();
        assertNotNull(response);
    }

    /**
     * Testing findRange method of class ExpenseFacadeREST.
     */
    //@Test
    private Expense[] testFindRange(int firstId, int lastId, Client client, WebTarget target) {
        if (client == null || target == null) return null;
        System.out.println("Calling the findRange by IDs Web Service API");
        
        Expense[] expenses = target.path("" +firstId).path("" +lastId).request("application/json").get(Expense[].class);
        assertNotNull(expenses);
        assertNotNull(expenses.length == lastId - firstId);
        assertNotNull(expenses[0].getId() == firstId);
        assertNotNull(expenses[expenses.length-1].getId() == lastId);        
        //System.out.println("Expenses returned by API = " + expenses);
        return expenses;
    }

    /**
     * Testing findAll method of class ExpenseFacadeREST.
     */
    //@Test
    private Expense[] testFindAll(Client client, WebTarget target) {
        if (client == null || target == null) return null;
        System.out.println("Calling the findAll Web Service API");
        Expense[] expenses = target.request("application/json").get(Expense[].class);
        assertNotNull(expenses);
        //System.out.println("Expenses returned by API = " + expenses);
        return expenses;
    }

    /**
     * Tests the class ExpenseFacadeREST using its web services API.
     */
    @Test
    public void testAll() throws Exception {
        System.out.println("Testing the web services API of ExpenseFacadeREST");
        String expensesUrl = BASE_URI + "/expenses";

        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        WebTarget target = client.target("http://localhost:8080/api/expenses");

        
        //fetch list of all expenses from API
        Expense[] expenses = testFindAll(client, target);
        System.out.println("Number Of Expenses in List of Expenses returned by API = " + expenses.length);
        //System.out.println("All Expenses returned by API: " +expenses +"/n");

        
        //get expenses count from API
        Integer count = testCount(client, target);                
        System.out.println("Expenses Count returned by API = " + count);
        assertTrue(count == expenses.length);

        
        /* insert new expense into DB via API
        //TODO: testCreate: not working now, causes a Bean Validation constraint(s) violation while calling
        //  public void org.schragl.codingtest.api.ExpenseFacadeREST.create
        //testCreate(client, target);
        //testCreate();
        
        //now there should be one more expense:
        
        //fetch list of all expenses from API
        int expLenPrev = expenses.length;
        expenses = testFindAll(client, target);
        System.out.println("Number Of Expenses in List of Expenses returned by API = " + expenses.length);
        assertTrue(expenses.length == expLenPrev + 1);
        
        //get expenses count from API
        int expCntPrev = count;
        count = testCount(client, target);                
        System.out.println("Expenses Count returned by API = " + count);
        assertTrue(count == expenses.length);
        assertTrue(count == expCntPrev + 1);
        */
        
        
        //TODO: testEdit: not working now, causes a Bean Validation constraint(s) violation while calling
        //  public void org.schragl.codingtest.api.ExpenseFacadeREST.edit
        //testEdit(18, client, target);
        
        
        //test find and find range
        Expense expense1 = testFind(1, client, target);
        assertNotNull(expense1);
        assertNotNull(expense1.getId() == 1);
        
        
        //test find range
        Expense[] expenseRange = testFindRange(12, 18, client, target);

        
        //delete the expense we just created via API:
        //TODO: for this to work properly the entity that gets removed needs to be restored after the test!
        testDelete(31, client, target);
        Expense expenseDeleted = testFind(31, client, target);
        assertNull(expenseDeleted);
                
        //DONE!
        client.close();
    }
}
