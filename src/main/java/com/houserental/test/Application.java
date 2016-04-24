package com.houserental.test;



import com.houserental.repository.landlord.LandlordRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * for testing purpose
 */
@Component
public class Application {

//        @Autowired
//        LandlordServices landlordServices;


    public static void main(String[] args) {

        ApplicationContext ac =
                new FileSystemXmlApplicationContext(
                        "src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"
                );

        LandlordRepo landlordRepo = ac.getBean(LandlordRepo.class);
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new ClassPathResource("applicationContext.xml").getPath());
//
//            LandlordRepo landlordRepo = context.getBean(LandlordRepo.class);
//
////        CounterService counterService = (CounterService) context.getBean(CounterService.class);
//
//        Landlord landlordAchilles = new Landlord();
//        landlordAchilles.setPhoneNum("111-111-1111");
//        landlordAchilles.setEmail("achilles@gmail.com");
//        landlordAchilles.setName("ivan");
//
//
//        landlordRepo.save(landlordAchilles);
//
//        Address address = new Address("1 Washington St.", "San Jose", "CA", "94539");
//
//        HouseInfo house1 = new HouseInfo();
//
//        house1.setHouseId("0");
//        house1.setAddress(address);
//        house1.setPropertyType("town house");
//        house1.setNumOfBathroom(3);
//        house1.setNumOfBedroom(4);
//        house1.setSqrtft(400d);
//        house1.setPrice(1000.0d);
//        house1.setDescription("house 1 owned by 111-111-1111");
//        house1.setStatus("open");
//        house1.setPostingDate("2016-04-16");
//
//        Landlord retrieveLL = landlordRepo.searchByPhoneNum("111-111-1111");
//
//        List<HouseInfo> houseList = new ArrayList<HouseInfo>();
//        houseList.add(house1);
//        retrieveLL.setHouseOwned(houseList);
//
//        landlordRepo.save(retrieveLL);
//
//        context.close();
//
//        Application p = context.getBean(Application.class);

//        p.test();
    }

    private void test(){
//        HouseInfo house1 = new HouseInfo();
//
//        Address address = new Address("204 peninsula", "san francisco", "CA", "94134");
//        house1.setAddress(address);
//        house1.setPropertyType("single house");
//        house1.setNumOfBathroom(2);
//        house1.setNumOfBedroom(5);
//        house1.setSqrtft(600d);
//        house1.setPrice(1500.0d);
//        house1.setDescription("house 1 owned by 222-222-222");
//        house1.setStatus("open");
//        house1.setPostingDate("2016-04-20");
//        landlordServices.addHousing("ivan",house1);
        //landlordServices.chgHouseSts("ivan","1","closed");
//        System.out.println(landlordServices.rtvAllPhouse("ivan").size());
    }
}
