package com.seclore.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.seclore.connection.ConnectionFactory;
import com.seclore.interfaces.LibraryManagerDao;
import com.seclore.pojo.Book;
import com.seclore.pojo.Member;
import com.seclore.pojo.Order;

public class LibraryManagerDaoImpl implements LibraryManagerDao {
	
	private Member member;
	private Book book;
	private Connection connection;
	private String sql;
	private PreparedStatement preparedStatement;
	private int count;
	private ResultSet resultSet=null,resultSet1=null,resultSet2=null;
	@Override
	public Member getMember (String member_code)
	{
		
		try {
			connection= ConnectionFactory.getDBConnection();
			sql= "select * from member_master where member_code=?";
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, member_code);
			resultSet1= preparedStatement.executeQuery();
		if(resultSet1!=null)
		{
			member=new Member();
			while (resultSet1.next())
			{
			   member.setMember_code(resultSet1.getString("member_code"));
			   member.setName(resultSet1.getString("name"));
			   member.setMember_type(resultSet1.getString("member_type"));
			   member.setIssue_capacity(resultSet1.getInt("issue_capacity"));
			}
			return member;
		}
		else
		{
			return null;
		}
		} catch (FileNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public Book getBook (String book_code)
	{
		try {
			connection= ConnectionFactory.getDBConnection();
			sql= "select * from book_master where book_code=?";
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, book_code);
			resultSet2= preparedStatement.executeQuery();
		if(resultSet2!=null)
		{
			Book book=new Book();
			while (resultSet2.next())
			{
			   book.setBook_code(resultSet2.getString("book_code"));
			   book.setTitle(resultSet2.getString("title"));
			   book.setAuthor(resultSet2.getString("author"));
			   book.setIssue_book(resultSet2.getString("issue_book"));
			   book.setQuantity(resultSet2.getInt("quantity"));
			}
			return book;
		}
		else
		{
			return book;
		}
		} catch (FileNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public Order getOrder (int order_id)
	{
		Order order=new Order();
		try {
			connection= ConnectionFactory.getDBConnection();
			sql= "select * from order_master where order_id=?";
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, order_id);
			resultSet= preparedStatement.executeQuery();
			while (resultSet.next())
			{
				order.setOrder_id(resultSet.getInt("order_id"));
				order.setDue_date(resultSet.getDate("due_date"));
				order.setIssue_date(resultSet.getDate("issue_date"));
				order.setStatus(resultSet.getString("status"));
				Book book= this.getBook(resultSet.getString("book_code"));
				Member member= this.getMember(resultSet.getString("member_code"));
				order.setBook(book);
				order.setMember(member);
			}
			return order;
		} catch (FileNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public boolean issueBook(Order order)
	{
		try {
			connection= ConnectionFactory.getDBConnection();
			sql= "insert into order_master (member_code,book_code,issue_date,due_date,status) values (?,?,?,?,?)";
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, order.getMember().getMember_code());
			preparedStatement.setString(2, order.getBook().getBook_code());
			preparedStatement.setDate(3, order.getIssue_date());
			preparedStatement.setDate(4, order.getDue_date());
			preparedStatement.setString(5, order.getStatus());
			count= preparedStatement.executeUpdate();
			if (count>0)
			{
				return true;
			}
		} catch (FileNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean returnBook(int order_id)
	{
		try {
			connection= ConnectionFactory.getDBConnection();
			sql= "update order_master set status=? where order_id=?";
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1,"Returned");
			preparedStatement.setInt(2,order_id);
			count= preparedStatement.executeUpdate();
			if (count>0)
			{
				return true;
			}
		} catch (FileNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean deleteBook(int order_id)
	{
		try {
			connection= ConnectionFactory.getDBConnection();
			sql= "delete from order_master where order_id=?";
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1,order_id);
			count= preparedStatement.executeUpdate();
			if (count>0)
			{
				return true;
			}
		} catch (FileNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	@Override
	public void showOrder_id ()
	{
		try {
		connection= ConnectionFactory.getDBConnection();
		sql= "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'library' AND TABLE_NAME = 'order_master'";
		preparedStatement= connection.prepareStatement(sql);
		resultSet= preparedStatement.executeQuery();
		while (resultSet.next())
		{
			System.out.println("Order id is: "+ resultSet.getInt("AUTO_INCREMENT"));
		}
		}
		 catch (FileNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Override
	public void getRecord ()
	{
		try {
			connection= ConnectionFactory.getDBConnection();
			sql= "select * from order_master";
			preparedStatement= connection.prepareStatement(sql);
			resultSet= preparedStatement.executeQuery();
			System.out.println("OrderId \t Member Code \t Book Code \t Issue Date \t Due Date \t Status");
			while (resultSet.next())
			{
				System.out.print(resultSet.getInt("order_id")+"\t");
				System.out.print(resultSet.getString("member_code")+"\t");
				System.out.print(resultSet.getString("book_code")+"\t");
				System.out.print(resultSet.getDate("issue_date")+"\t");
				System.out.print(resultSet.getDate("due_date")+"\t");
				System.out.print(resultSet.getString("status"));
				System.out.println();
			}
			}
			 catch (FileNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
