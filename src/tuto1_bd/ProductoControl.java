package tuto1_bd;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductoControl {

public String insertar(Producto p) {
		
		ConexionBD conex = new ConexionBD();
		String resultado = "nose";
		
		try {
			
			Statement st= conex.getConnection().createStatement();
			String sql = "INSERT INTO producto(pro_nombre, pro_precio) VALUES ('"+p.getNombre()+"' , "+p.getPrecio()+")" ;
			st.executeUpdate(sql);
			st.close();
			conex.desconectar();
					
			resultado="exito";
			
		}catch(Exception e) {
			resultado = "error"+e;
		}
		
		
		
		return resultado;
	}

		public ArrayList<Producto> listar(){
			
			ConexionBD conex = new ConexionBD();
			ArrayList<Producto> listaDeProductos = new ArrayList<Producto>(); 
			
			try {
				Statement st = conex.getConnection().createStatement();
				String sql = "SELECT * FROM producto";
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					
					int codigo = Integer.parseInt(rs.getString("pro_codigo"));
					String nombre = rs.getString("pro_nombre");
					int precio = rs.getInt("pro_precio");
					
					Producto p = new Producto();
					p.setCodigo(codigo);
					p.setNombre(nombre);
					p.setPrecio(precio);
					
					listaDeProductos.add(p);
				}
				
			}catch(Exception e) {
				System.out.println("Error"+e);
			}
			
			
			return listaDeProductos;
		}
	
}
