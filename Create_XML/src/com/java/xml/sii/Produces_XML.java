package com.java.xml.sii;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.java.xml.dao.Metodos_XML;
import com.java.xml.model.Resolucion;

@Path("produce")
public class Produces_XML 
{
    
	 private static final String BOOKSTORE_XML = "./bookstore-jaxb.xml";
	
	
	
	@Path("XML")
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Resolucion getBothResponse()
    {
    	List<Fea> s = new ArrayList<Fea>();
        Fea f = new Fea();
        Resolucion r = new Resolucion();
        Metodos_XML dao = new Metodos_XML();
        
        try {
			s = dao.queryReturnElements();
			f.setAge(s.get(0).getAge());
			f.setDOLE_AGNO(s.get(0).getDOLE_AGNO());
			f.setDOLE_REGIONAL(s.get(0).getDOLE_REGIONAL());
			
			r.setFea(f);
			
			JAXBContext context = JAXBContext.newInstance(Resolucion.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out
            m.marshal(r, System.out);

            // Write to File
            m.marshal(r, new File(BOOKSTORE_XML));

            // get variables from our xml file, created before
            System.out.println();
            System.out.println("Output from our XML File: ");
            //Unmarshaller um = context.createUnmarshaller();
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        
        return r;
    }
}
