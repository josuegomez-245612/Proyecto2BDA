/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesNegocio;

import Utilidades.TramitesDTO;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Ryzen 5
 */
public interface IValidadoresTramites 
{

    /**
     *
     * @param nombreCompleto
     * @return
     */
    public List<TramitesDTO> cargarTramitesByNombre(String nombreCompleto);

    /**
     *
     * @param periodoInicio
     * @param periodoFin
     * @return
     */
    public List<TramitesDTO> cargarTramitesInPeriod(Calendar periodoInicio, Calendar periodoFin);

    /**
     *
     * @param nombreCompleto
     * @param periodoInicio
     * @param periodoFin
     * @return
     */
    public List<TramitesDTO> cargarTramitesByNombreInPeriod(String nombreCompleto, Calendar periodoInicio, Calendar periodoFin);

    /**
     *
     * @return
     */
    public List<TramitesDTO> cargarTodosTramites();
}
