/**
 * 
 */
package jk.research.spring.jdbc.poc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.javafaker.Faker;

import jk.research.spring.jdbc.poc.domain.ClaimSettlement;
import jk.research.spring.jdbc.poc.domain.ClaimSettlementMap;
import jk.research.spring.jdbc.poc.service.ClaimSettlementService;

public class AppMain {

	public static void main(String[] args) throws Exception {

		// open/read the application context file
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("app-ctx.xml");

		populateClaimSettlementsData(ctx);
	}

	private static void populateClaimSettlementsData(ApplicationContext ctx) throws Exception {

		Faker faker = new Faker();

		ClaimSettlementService service = ctx.getBean(ClaimSettlementService.class);

		List<ClaimSettlementMap> settlementMaps = null;

		ClaimSettlement claimSettlement = null;
		for (int rowCtr = 1; rowCtr <= 3; rowCtr++) {

			claimSettlement = new ClaimSettlement(new Long(faker.random().nextInt(1000)),
					new Long(faker.random().nextInt(2000)), faker.educator().campus(), faker.commerce().department());

			settlementMaps = generateClaimSettlementMapList(faker);

			service.populateClaimSettlements(claimSettlement, settlementMaps);
		}
	}

	private static List<ClaimSettlementMap> generateClaimSettlementMapList(Faker faker) {
		List<ClaimSettlementMap> settlementMaps;
		settlementMaps = new ArrayList<>();

		ClaimSettlementMap settlementMap = null;

		for (int stlMapCtr = 1; stlMapCtr <= 10; stlMapCtr++) {

			settlementMap = new ClaimSettlementMap();
			settlementMap.setClaimICDCounterPartyId(new Long(faker.random().nextInt(1000)));

			settlementMaps.add(settlementMap);
		}

		return settlementMaps;
	}

}

//IntStream.range(0, 100).forEach(index -> {
//
//	ClaimSettlement claimSettlement = new ClaimSettlement(faker.random().nextLong(), faker.random().nextLong(),
//			faker.educator().campus(), faker.commerce().department());
//
//	claimStlDAO.createClaimSettlement(claimSettlement);
//});
