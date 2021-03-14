package com.example.sproute.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import com.example.repository.mapper.AuctionMapperRepository;
import com.example.repository.session.AuctionSessionRepository;
import com.example.sproute.domain.Auction;
import com.example.sproute.domain.Bidding;

@Service
public class AuctionService {

   @Autowired
   private AuctionMapperRepository AuctionRepository;
   @Autowired
   private AuctionSessionRepository asr;
   
   @Autowired      // applicationContext.xml에 정의된 scheduler 객체를 주입 받음
   private ThreadPoolTaskScheduler scheduler;
      
   public void testScheduler(Date closingTime) {
         
      Runnable updateTableRunner = new Runnable() {   
               // anonymous class 정의
         @Override
         public void run() {   // 스케쥴러에 의해 미래의 특정 시점에 실행될 작업을 정의            
            Date curTime = new Date();
            // 실행 시점의 시각을 전달하여 그 시각 이전의 closing time 값을 갖는 event의 상태를 변경 
            AuctionRepository.closeAuction(curTime);   // EVENTS 테이블의 레코드 갱신   
            System.out.println("updateTableRunner is executed at " + curTime);
         }
      };
            
   
      // 스케줄 생성: closingTime에 updateTableRunner.run() 메소드 실행
      scheduler.schedule(updateTableRunner, closingTime);  
            
      System.out.println("updateTableRunner has been scheduled to execute at " + closingTime);
   }
   
   public Integer insertAuctionItem(Auction auction) {
      return AuctionRepository.insertAuctionItem(auction);
   }
   
   public Integer maxPriceAuction(String auctionId) {
      return AuctionRepository.maxPriceAuction(auctionId);
   }
   
   public Integer bidCount(String auctionId) {
      return AuctionRepository.bidCount(auctionId);
   }
   
   public void insertBid(Bidding bid) {
      AuctionRepository.insertBid(bid);
   }
   
   public void updateParticipant(String itemId) {
      AuctionRepository.updateParticipant(itemId);
   }
   
   public Integer updateParticipantAfter(String auctionId) {
      return asr.updateParticipantAfter(auctionId);
   }
   public String selectAuctionId(String bidId) {
      return asr.selectAuctionId(bidId);
   }
}