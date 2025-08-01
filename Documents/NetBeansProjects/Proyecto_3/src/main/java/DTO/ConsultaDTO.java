/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Jean Pool
 */
import java.io.Serializable;
import java.util.Date;

    public class ConsultaDTO implements Serializable {
        private String codigo;
        private Date fecha;
        private String motivo;

        public ConsultaDTO(String codigo, Date fecha, String motivo) {
            this.codigo = codigo;
            this.fecha = fecha;
            this.motivo = motivo;
        }

        public String getCodigo() {
            return codigo; 
        }
        public Date getFecha() {
            return fecha; 
        }
        public String getMotivo() {
            return motivo; 
        }
}