/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;



import java.util.ArrayList;
import persistencia.GestorPersistencia;
import DTO.ConsultaDTO;
import excepciones.ConsultaInvalidaException;

public class ConsultaDAO {
    private final String ruta = "data/consultas.dat";
    private final GestorPersistencia gestor = GestorPersistencia.getInstance();

    public ConsultaDAO() {
    }

    private static ConsultaDAO instancia;
    
    public static ConsultaDAO getInstancia(){
         if(instancia == null){
             instancia = new ConsultaDAO();
         }
         return instancia;
    }
    
    public boolean guardarConsultas(ConsultaDTO consulta) {
        ArrayList<ConsultaDTO> lista = listar();
        lista.add(consulta);
       gestor.guardarLista(ruta, lista);
       return true;
    }

    public ArrayList<ConsultaDTO> listar() {
        ArrayList<ConsultaDTO> lista = gestor.cargarLista(ruta);
        return lista != null ? lista : new ArrayList<>();
    }

    public boolean eliminarConsulta(String codigo) {
        ArrayList<ConsultaDTO> lista = listar();
        if (codigo.equals(codigo)) {
            lista.remove(codigo);
            gestor.guardarLista(ruta, lista);
        }
        throw new ConsultaInvalidaException("La consulta con codigo " + codigo + " no se pudo eliminar.");
    }
     
    public ConsultaDTO buscarConsultaPorCodigo(String codigo) {
        ArrayList<ConsultaDTO> lista = listar();
        for (ConsultaDTO m : lista) {
            if (m.getCodigo() == codigo ) {   // ID es int
                return m;
            }
        }  
        throw new ConsultaInvalidaException("La consulta no se encontro.");
    }

    public boolean actualizar(String codigo, ConsultaDTO consultaEditada) {
        ArrayList<ConsultaDTO> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            ConsultaDTO actual = lista.get(i);
            if (actual.getCodigo() == consultaEditada.getCodigo()) {
                lista.set(i, consultaEditada);
                gestor.guardarLista(ruta, lista);
                return true;
            }
        }
        return false;
    }
 
    
}


   /* private final File archivo = new File("consultas.dat");

    public void guardarConsulta(Consulta consulta) throws IOException {
        List<Consulta> lista = listarConsultas();
        lista.add(consulta);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(lista);
        }
    }

    public List<Consulta> listarConsultas() {
        if (!archivo.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Consulta>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }*/
    

