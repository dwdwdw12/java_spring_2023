package com.ezen.mybatis.project;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MainClass {
	
	public static void main(String[] args) {
	
		try {
			String resource = "com/ezen/mybatis/project/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			System.out.println("sqlSessionFactory >>> " + sqlSessionFactory);	// mybatis 연결 확인
			
			SqlSession session = sqlSessionFactory.openSession(true);
//			System.out.println("session >> " + session);	// session 연결 확인
			
//			BlogMapper mapper = session.getMapper(BlogMapper.class);
			MapperInterface mapper = session.getMapper(MapperInterface.class);
//			Blog blog = mapper.selectBlog(101);
			MemberVO mVo = mapper.selectOne(00002);
			System.out.println(mVo);
			
	//insert
/*			mVo.setId(00003);
			mVo.setName("조운");
			mVo.setPhone("011-223-3334");
			mVo.setAddress("경기도");
			int result = mapper.insertMember(mVo);
			System.out.println("result : " + result);
*/	
			
/*	//delete		
			int result2 = mapper.deleteMember(00003);
			System.out.println("result2 : " + result2);
*/
	
	//update
/*			mVo.setId(00003);
			mVo.setName("길동");
			mVo.setPhone("000-222-3334");
			mVo.setAddress("서울시");
			int result = mapper.updateMember(mVo);
			System.out.println("result : " + result);
*/			
			
			List<MemberVO> list = mapper.selectAll();
			for(MemberVO vo : list) {
				System.out.println(">>" + list);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
