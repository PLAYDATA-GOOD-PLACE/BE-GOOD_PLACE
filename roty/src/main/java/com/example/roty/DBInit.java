//package com.example.roty;
//
//
//import com.example.roty.domain.entity.Store;
//import com.example.roty.store.repository.StoreRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class DBInit {
//
//    private final StoreRepository storeRepository;
//
//    @Bean
//    private void init(){
//
//       for (int i=0;i<10;i++){
//           Store build = Store.builder()
//                   .placeId("" + i)
//                   .name("테스트"+i)
//                   .address("주소"+i)
//                   .phone("폰번호"+i)
//                   .foodType("타입"+i)
//                   .build();
//           storeRepository.save(build);
//       }
//    }
//}
