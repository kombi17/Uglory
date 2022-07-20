package edu.kh.ugloryC.subscription.model.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.ugloryC.subscription.model.vo.OrderInfo;

@Repository
public class SubscriptionDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 주문번호 생성
	public String createSOrderNo(OrderInfo orderInfo) {
		
		String subsOrderNo = sqlSession.selectOne("subscriptionMapper.createSOrderNo", orderInfo);
		
		return subsOrderNo;
	}


	// 첫 배송일 지정 
	public Date createDelDate() {
		return sqlSession.selectOne("subscriptionMapper.createDelDate");
	}

	// 주문 삽입
	public int insertSubsOrder(Map<String, Object> payInfo) {
		
		return sqlSession.insert("subscriptionMapper.insertSubsOrder", payInfo);
	}


	public String checkSubs(int memberNo) {
		return sqlSession.selectOne("subscriptionMapper.checkSubs", memberNo);
	}


	public int insertException(Map<String, Object> payInfo) {
		System.out.println(payInfo);
		
		int result = 0;
		
		if( payInfo.get("choice") != null) {
			result =  sqlSession.insert("subscriptionMapper.exception", payInfo);	
		}else {
			result = 0;
		}
		
		return result;
	}


	public int insertPay(Map<String, Object> payInfo) {
		return sqlSession.insert("subscriptionMapper.insertPay", payInfo);
	}
	
	
}
