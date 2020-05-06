package com.seclore.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.seclore.connection.ConnectionFactory;
import com.seclore.interfaces.LibraryAdminDao;
import com.seclore.pojo.Book;
import com.seclore.pojo.Member;

public class LibraryAdminDaoImpl implements LibraryAdminDao {
	private Connection connection;
	private String sql;
	private PreparedStatement preparedStatement;
	private int count;
	@Override
	public boolean addBook(Book book)
	{
		try {
			connection= ConnectionFactory.getDBConnection();
			sql= "insert into book_master values(?,?,?,?,?)";
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, book.getBook_code());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.setString(3, book.getAuthor());
			preparedStatement.setString(4, book.getIssue_book());
			preparedStatement.setInt(5, book.getQuantity());
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
	public boolean updateBook(Book book)
	{
		try {
			connection= ConnectionFactory.getDBConnection();
			sql= "update book_master set title=?,author=?,issue_book=?,quantity=? where book_code=?";
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setString(3, book.getIssue_book());
			preparedStatement.setInt(4, book.getQuantity());
			preparedStatement.setString(5, book.getBook_code());
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
	public boolean deleteBook (String book_id)
	{
		try {
			connection= ConnectionFactory.getDBConnection();
			sql= "delete from book_master where book_code=?";
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, book_id);
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

	//for member
	
	@Override
	public boolean addMember(Member member)
	{
		try {
			connection= ConnectionFactory.getDBConnection();
			sql= "insert into member_master values(?,?,?,?)";
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1,member.getMember_code());
			preparedStatement.setString(2, member.getName());
			preparedStatement.setString(3, member.getMember_type());
			preparedStatement.setInt(4, member.getIssue_capacity());
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
	public boolean updateMember(Member member)
	{
		try {
			connection= ConnectionFactory.getDBConnection();
			sql= "update member_master set name=?,member_type=?,issue_capacity=? where member_code=?";
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, member.getName());
			preparedStatement.setString(2, member.getMember_type());
			preparedStatement.setInt(3, member.getIssue_capacity());
			preparedStatement.setString(4, member.getMember_code());
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
	public boolean deleteMember (String member_id)
	{
		try {
			connection= ConnectionFactory.getDBConnection();
			sql= "delete from member_master where member_code=?";
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, member_id);
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

}
