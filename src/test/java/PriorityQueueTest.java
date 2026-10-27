import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PriorityQueueTest
{
	PriorityQueue<Customer> PQueue;
	Comparator<Customer> comp;

 	Customer CustA;
 	Customer CustATwin;
	Customer CustB;
	Customer CustC;
	Customer CustD;
	
	Customer CustE;
	Customer CustF;
	
	Customer CustATie;
	Customer CustBTwin;
	
	Customer MrSucksALot;    // 1. Define comparators as static fields

	Customer.WorthPoliteComparator By_Politeness = new Customer.WorthPoliteComparator(); 
	Customer.LoyaltyComparator By_Loyalty = new Customer.LoyaltyComparator();  
	Customer.WorthComparator By_Worth = new Customer.WorthComparator();  
	@BeforeEach 
	void setUp()
	{
		comp = new Customer.WorthPoliteComparator(); 
		PQueue	= new PriorityQueue<Customer>(comp);
		
		CustA = new Customer(5,5,5);
		CustATwin = new Customer(5,5,5);
		CustB = new Customer(4,4,4);
		CustC = new Customer(3,3,3);
		CustD = new Customer(2,2,2);
		
		CustATie = new Customer(5,5,6);
		CustBTwin = new Customer(4,4,4);
		
		MrSucksALot = new Customer(0,0,0);
		
		CustE = new Customer(5,5,5);
		CustF = new Customer(5,5,4);
		
		
		
	}
	
	
	@Test
	void testStandardInsert()
		{
			PQueue.push(CustA);
			assertEquals(CustA, PQueue.pop()); //Empty Queue Case
			
			PQueue.push(CustA);
			PQueue.push(CustC);
			PQueue.push(CustB);
			PQueue.push(CustD);
			
			assertEquals(CustA, PQueue.pop());
			assertEquals(CustB, PQueue.pop());
			assertEquals(CustC, PQueue.pop());
			assertEquals(CustD, PQueue.pop());
			
			//EveryBodyShouldBeInOrder
			
		}
	
	@Test
	void testTieBreaker()
		{
			PQueue.push(CustA);
			PQueue.push(CustATie);
			
			assertEquals(CustATie, PQueue.pop());
			assertEquals(CustA, PQueue.pop());
			//Winner Of Tie Goes In Front If CHALLENGER
		}
	
	@Test
	void testTwins()
	{
			PQueue.push(CustBTwin);
			PQueue.push(CustB);
			assertEquals(CustBTwin, PQueue.pop());
			assertEquals(CustB, PQueue.pop());
			//Oldest Twin Should Be In Front *According to DrB
	
	}
	
	@Test
	void testPoliterTieBreaker()
	{
			assertTrue(By_Politeness.compare(CustA,CustB)>0);
			assertTrue(By_Politeness.compare(CustB, CustA)<0);
			assertTrue(By_Politeness.compare(CustA,CustATwin)==0);
			
			assertTrue(By_Politeness.compare(CustE, CustF)>0);
			assertTrue(By_Politeness.compare(CustF, CustE)<0);
			assertTrue(By_Politeness.compare(CustE,CustE)==0);
			
			/*
			assertTrue(By_Politeness.compare(CustB,CustA)<0);
			assertTrue(By_Politeness.compare(CustA,CustB)>0);
			assertTrue(By_Politeness.compare(CustA,CustA)==0);
			
			assertTrue(By_Politeness.compare(CustE, CustF)<0);
			assertTrue(By_Politeness.compare(CustF, CustE)>0);
			assertTrue(By_Politeness.compare(CustE,CustE)==0);
			*/
			
	}
	
	@Test
	void testLoyalty()
	{
			assertTrue(By_Loyalty.compare(CustB,CustA)<0);
			assertTrue(By_Loyalty.compare(CustA,CustB)>0);
			assertTrue(By_Loyalty.compare(CustA,CustA)==0);
			
			
	}
	
	@Test
	void testWorth()
	{
			assertTrue(By_Worth.compare(CustB,CustA)<0);
			assertTrue(By_Worth.compare(CustA,CustB)>0);
			assertTrue(By_Worth.compare(CustA,CustA)==0);
			

	}

	
}	

