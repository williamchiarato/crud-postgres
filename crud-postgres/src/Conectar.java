import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conectar {
	public static void main(String args[]) {
	      Connection c = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/crud-teste",
	            "postgres", "691618");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
	         
	         //insert
	         stmt = c.createStatement();
	         String sql = "INSERT INTO usuario (id, nome, sobrenome, idade) VALUES (2, 'William', 'Chiarato', 20);";
	         stmt.executeUpdate(sql);
	         
	         stmt.close();
	         c.commit();
	         //c.close();
	         // --
	         
	         //select
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM usuario;" );
	         while ( rs.next() ) {
	            String name = rs.getString("nome");
	            int idade = rs.getInt("idade");
	            System.out.println( "Nome: " + name );
	            System.out.println( "Idade: " + idade );
	            System.out.println();
	         }
	         rs.close();
	         stmt.close();
	         //c.close();
	         // --
	         
	         //update
	         stmt = c.createStatement();
	         String sql1 = "UPDATE usuario set nome = 'Jose' where id = 1;";
	         stmt.executeUpdate(sql1);
	         c.commit();

	         while ( rs.next() ) {
	        	 String name = rs.getString("nome");
		         int idade = rs.getInt("idade");
		         System.out.println( "Nome: " + name );
		         System.out.println( "Idade: " + idade );
		         System.out.println();
		     }
	         rs.close();
	         stmt.close();
	         //c.close();
	         // --
	         
	         //delete
	         stmt = c.createStatement();
	         String sql2 = "DELETE from COMPANY where id = 1;";
	         stmt.executeUpdate(sql2);
	         c.commit();

	         while ( rs.next() ) {
	        	 String name = rs.getString("nome");
		         int idade = rs.getInt("idade");
		         System.out.println( "Nome: " + name );
		         System.out.println( "Idade: " + idade );
		         System.out.println();
		     }
	         rs.close();
	         stmt.close();
	         c.close();
	         // --
	         
	      } catch (Exception e) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      
	      System.out.println("Records created successfully");
	   }
}
