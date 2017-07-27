package lizem.model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class StringArrayHandler extends BaseTypeHandler<String[]> {

	@Override
	public String[] getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		String likeArray = rs.getString(columnName);
		String[] likes = likeArray.split(",");
		return likes;
	}

	@Override
	public String[] getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		String likeArray = rs.getString(columnIndex);
		String[] likes = likeArray.split(",");
		return likes;
	}

	@Override
	public String[] getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		String likeArray = cs.getString(columnIndex);
		String[] likes = likeArray.split(",");
		return likes;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			String[] parameter, JdbcType jdbcType) throws SQLException {
		String value = "";

		// 循环数组 拼出 以逗号分割的字符串
		for (String temp : parameter) {
			value = value + temp + ",";
		}
		ps.setString(i, value);
		
	}


}
