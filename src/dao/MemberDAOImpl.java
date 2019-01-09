package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import domain.MemberBean;
import pool.Constant;

public class MemberDAOImpl implements MemberDAO {

	private static MemberDAOImpl instance = new MemberDAOImpl();

	private MemberDAOImpl() {
	}

	public static MemberDAOImpl getInstance() {
		return instance;
	}

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	public void insertMember(MemberBean memberBean) {
		try {
			Class.forName(Constant.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constant.ORACLE_URL, Constant.USERNAME, Constant.PASSWORD);
			stmt = conn.createStatement();
			String sql = String.format("INSERT INTO member(name,ssn,id,pass) \n" + "VALUES('%s', '%s', '%s', '%s')",
					memberBean.getName(), memberBean.getSsn(), memberBean.getId(), memberBean.getPass());
			System.out.println("sql===" + sql);
			/*
			 * rs = stmt.executeQuery(sql); System.out.println("rs=="+rs); int a =
			 * stmt.executeUpdate(sql); System.out.println("int a==="+a);
			 */
			if (stmt.executeUpdate(sql) == 1) {
				System.out.println("회원가입 성공");
			} else {
				System.out.println("회원가입 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<MemberBean> selectMembers() {
		try {
			Class.forName(Constant.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constant.ORACLE_URL, Constant.USERNAME, Constant.PASSWORD);
			stmt = conn.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<MemberBean> selectMemberByName(String name) {
		try {
			Class.forName(Constant.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constant.ORACLE_URL, Constant.USERNAME, Constant.PASSWORD);
			stmt = conn.createStatement();
			String sql = String.format("INSERT INTO selectbyname(name) \n"
					+ "%s", name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MemberBean selectMemberById(String id) {
		MemberBean memberBean = new MemberBean();
		try {
			Class.forName(Constant.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constant.ORACLE_URL, Constant.USERNAME, Constant.PASSWORD);
			stmt = conn.createStatement();
			String sql = String.format("","");
			rs = stmt.executeQuery(sql);
			while(rs.next()) { //검색된 결과가 존재하면 true 리턴
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberBean;
	}

	@Override
	public int countMembers() {
		try {
			Class.forName(Constant.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constant.ORACLE_URL, Constant.USERNAME, Constant.PASSWORD);
			stmt = conn.createStatement();
			String sql = String.format("", "");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void updatePass(String id, String pass, String newPass) {
		try {
			Class.forName(Constant.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constant.ORACLE_URL, Constant.USERNAME, Constant.PASSWORD);
			stmt = conn.createStatement();
			String sql = String.format("INSERT INTO delete(id,pass) \n" + "VALUES('%s', '%s')", id, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMember(String id, String pass) {
		try {
			Class.forName(Constant.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constant.ORACLE_URL, Constant.USERNAME, Constant.PASSWORD);
			stmt = conn.createStatement();
			String sql = String.format("INSERT INTO delete(id,pass) \n" + "VALUES('%s', '%s')", id, pass);
			/*
			 * if(id.equals(bean.getId()) && pass.equals(bean.getPass())) {
			 * if(stmt.executeUpdate(sql)==0) { System.out.println("계정삭제"); } else {
			 * System.out.println("계정유지"); } }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}