package org.scoula.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    // 싱글톤처럼 1개의 연결만 유지하려고 함(성능고려)
    static Connection conn = null;

    public static Connection getConnection() {
        if(conn != null)
            return conn;
        try {
            Properties properties = new Properties();
            properties.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String id = properties.getProperty("id");
            String password = properties.getProperty("password");

            //JDBC 표준 연결 방식, 대부분의 DB연동 프로젝트에서 동일하게 사용
            // 1단계 (DB 드라이버 설정)
            Class.forName(driver);
            // 2단계(DB연결)
            conn = DriverManager.getConnection(url, id, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    // 4단계(결과처리 및 자원 해제)
    public static void close() {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/** JDBC 연결 4단계 흐름
 * 1. JDBC 드라이버 로딩
 * 2. DB 연결설정(url, 계정 등)
 * 3. Connection 객체 생성
 * 4. 자원 해제(close)
 * 정형화된 틀로 JDBCUtil공통 클래스로 모아두면 유지보수가 쉬워짐
 */