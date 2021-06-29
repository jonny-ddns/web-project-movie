package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class DBC {
	Connection conn				= null;
	PreparedStatement pstmt 	= null;
	ResultSet rs				= null;
}
