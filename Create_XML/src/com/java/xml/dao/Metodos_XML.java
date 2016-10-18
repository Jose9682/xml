package com.java.xml.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.xml.conn.ConexioDB;
import com.java.xml.sii.Fea;

public class Metodos_XML extends ConexioDB{

	
	
			public List<Fea> queryReturnElements() throws Exception {
					
				
				
					List<Fea> fea = new ArrayList<Fea>();  
					Fea feaObj = new Fea(); 
					PreparedStatement query = null;
					Connection conn = null;
					String sql = null;
					
					
					/*ToJSON converter = new ToJSON();
					JSONArray json = new JSONArray();
					*/
					try {
						conn = new ConexioDB().getConnection();
						/*query = conn.prepareStatement("select PC_PARTS_PK, PC_PARTS_TITLE, PC_PARTS_CODE, PC_PARTS_MAKER, PC_PARTS_AVAIL, PC_PARTS_DESC " +
														"from PC_PARTS " +
														"where UPPER(PC_PARTS_MAKER) = ? ");
						
						*/
						
						sql="SELECT NVL(DL.DOLE_UNIDAD_PADRE,0),NVL(DL.DOLE_REGIONAL,0),TRIM(REPLACE(NVL(UO.NOMBRE,0),'  ',' ')), "+                 
									"NVL(DL.DOLE_AGNO,0),NVL(DL.DOLE_NUMERO,0),NVL(DL.DOLE_COMUNA_ACTUAL,0),NVL(TRIM(C1.NOMBRE),' '), "+                                                
									"DECODE(DL.DOLE_REGIONAL,14,'SANTIAGO',NVL(TRIM(C2.NOMBRE),' ')),NVL(TRIM(C3.NOMBRE),' '), "+                                                
									"NVL(DL.DOLE_MANZANA_ACTUAL,0),NVL(DL.DOLE_PREDIO_ACTUAL,0),NVL(DL.DEST_EACS_CODIGO_DESPUES,0),NVL(DL.NUM_CARTA_NOTIF,0), "+                                                              
									"NVL(DL.AVALUO_ANTES,0),NVL(DL.AVALUO_DESPUES,0),NVL(DL.AV_PRORR_BC1_ANTES,0),NVL(DL.AV_PRORR_BC1_DESPUES,0), "+
									"NVL(DL.AV_PRORR_BC2_ANTES,0),NVL(DL.AV_PRORR_BC2_DESPUES,0),NVL(DL.AV_EXENTO_ANTES,0),NVL(DL.AV_EXENTO_DESPUES,0), "+
									"NVL(DL.CONTRIBUCION_ANTES,0), "+
						             "NVL(DL.CONTRIBUCION_DESPUES,0), "+
						             "NVL(DL.UBICACION_ANTES,' '), "+
						             "NVL(DL.UBICACION_DESPUES,' '), "+
						             "NVL(DL.DEST_CODIGO_ANTES,' '), "+
						             "NVL(DL.DEST_EACS_CODIGO_ANTES,0), "+
						             "NVL(DL.DEST_CODIGO_DESPUES,' '), "+
						             "NVL(DL.AGNO_VIG_DESDE,0), "+
						             "NVL(DL.SEMESTRE_VIG_DESDE,0), "+
						             "NVL(DL.AGNO_VIG_HASTA,0), "+
						             "NVL(DL.SEMESTRE_VIG_HASTA,0), "+
						             "NVL(DL.COD_DISP_LEGAL_1,' '), "+
						             "NVL(DL.COD_DISP_LEGAL_2,' '), "+
						             "NVL(DL.COD_DISP_LEGAL_3,' '), "+
						             "NVL(DL.COD_DISP_LEGAL_4,' '), "+
						             "NVL(DL.COD_DISP_LEGAL_5,' '), "+
						             "NVL(DL.COD_DISP_LEGAL_6,' '), "+
						             "NVL(DL.TIPO_NOTIFICACION,' '), "+
						             "NVL(DL.COMU_CODIGO_POSTAL,0), "+
						             "NVL(DL.GLCO_CONDICION,' '), "+
						             "NVL(TO_CHAR(DL.DOLE_FEC_FISCA,'DD.MM.YYYY'),' '), "+
						             "NVL(DL.DOLE_PER_PUBLICACION,0), "+
						             "NVL(DL.DOLE_COD_EXE_1_DESPUES,0), "+
						             "NVL(DL.DOLE_COD_EXE_2_DESPUES,0), "+
						             "NVL(DL.DOLE_TIPO_OPERACION,' '), "+
						             "NVL(DL.DOLE_NRO_FORMULARIO,0), "+
						             "NVL(TRIM(DL.DOLE_TIPO_DOCUMENTO),' '), "+
						             "NVL(DL.DOLE_NRO_DOCUMENTO,0), "+
						             "NVL(TO_CHAR(DL.DOLE_FEC_DOCUMENTO,'DD.MM.YYYY'),' '), "+
						             "NVL(DL.DOLE_DIRECCION,' '), "+
						             "NVL(DL.DOLE_NOM_PROPIETARIO,' '), "+
						             "NVL(DL.DOLE_RUT_PROPIETARIO,0), "+
						             "NVL(DL.DOLE_DV_PROPIETARIO,' '), "+
						             "NVL(DL.DOLE_DIR_POSTAL,' '), "+
						             "NVL(DL.DOLE_UNIDAD_PADRE,0), "+
						             "NVL(DL.DOLE_NUM_RES_IMPRESA,0), "+
						             "NVL(DL.DOLE_NRO_PROCESO,0), "+
						             "DECODE(NVL(("+
						             "DECODE(TRIM(DL.COD_DISP_LEGAL_1),'2A','S','2B','S','')|| "+
						             "DECODE(TRIM(DL.COD_DISP_LEGAL_2),'2A','S','2B','S','')|| "+
						             "DECODE(TRIM(DL.COD_DISP_LEGAL_3),'2A','S','2B','S','')|| "+
						             "DECODE(TRIM(DL.COD_DISP_LEGAL_4),'2A','S','2B','S','')|| "+
						             "DECODE(TRIM(DL.COD_DISP_LEGAL_5),'2A','S','2B','S','')|| "+
						             "DECODE(TRIM(DL.COD_DISP_LEGAL_6),'2A','S','2B','S','') "+
						             "),'N'),'SS','S','S','S','N','N','N'), "+
						             "NVL(SUBSTR(GLCO_CONDICION,1,1),' '), "+
						             "NVL(SUBSTR(GLCO_CONDICION,6,1),' '), "+
						             "NVL(SUBSTR(DOLE_PER_PUBLICACION,5,1),' '), "+
						             "NVL(SUBSTR(DOLE_PER_PUBLICACION,1,4),' '), "+
						             "NVL(PREN_COMUNA_CNP,0), "+
						             "NVL(PREN_MANZANA_CNP,0), "+
						             "NVL(PREN_PREDIO_CNP,0) "+
						             ",DECODE(DL.DOLE_SEM_CONT_CALC_1,0,0, "+
						             "SUBSTR(TO_CHAR(DL.DOLE_SEM_CONT_CALC_1),1,4))|| "+
						             " DECODE(DL.DOLE_SEM_CONT_CALC_1,0,'','-')   || "+ 
						             " DECODE(DL.DOLE_SEM_CONT_CALC_1,0,'', "+
						             "SUBSTR(TO_CHAR(DL.DOLE_SEM_CONT_CALC_1),5,1)), "+ 
						             "NVL(DL.DOLE_CONT_CALC_1,0), "+
						             "DECODE(DL.DOLE_SEM_CONT_CALC_2,0,0, "+
						             "SUBSTR(TO_CHAR(DL.DOLE_SEM_CONT_CALC_2),1,4))|| "+
						             "DECODE(DL.DOLE_SEM_CONT_CALC_2,0,'','-')   || "+ 
						             "DECODE(DL.DOLE_SEM_CONT_CALC_2,0,'', "+
						             "SUBSTR(TO_CHAR(DL.DOLE_SEM_CONT_CALC_2),5,1)), "+
						             "NVL(DL.DOLE_CONT_CALC_2,0), "+
						             "DECODE(DL.DOLE_SEM_CONT_CALC_3,0,0, "+
						             "SUBSTR(TO_CHAR(DL.DOLE_SEM_CONT_CALC_3),1,4))|| "+
						             "DECODE(DL.DOLE_SEM_CONT_CALC_3,0,'','-')   || "+ 
						             "DECODE(DL.DOLE_SEM_CONT_CALC_3,0,'', "+
						             "SUBSTR(TO_CHAR(DL.DOLE_SEM_CONT_CALC_3),5,1)), "+
						             "NVL(DL.DOLE_CONT_CALC_3,0), "+
						             "DECODE(DL.DOLE_SEM_CONT_CALC_4,0,0, "+
						             "SUBSTR(TO_CHAR(DL.DOLE_SEM_CONT_CALC_4),1,4))|| "+
						             "DECODE(DL.DOLE_SEM_CONT_CALC_4,0,'','-')   || "+ 
						             "DECODE(DL.DOLE_SEM_CONT_CALC_4,0,'', "+
						             "SUBSTR(TO_CHAR(DL.DOLE_SEM_CONT_CALC_4),5,1)), "+
						             "NVL(DL.DOLE_CONT_CALC_4,0), "+
						              "DECODE(DL.DOLE_SEM_CONT_CALC_5,0,0, "+
						              "SUBSTR(TO_CHAR(DL.DOLE_SEM_CONT_CALC_5),1,4))|| "+
						              "DECODE(DL.DOLE_SEM_CONT_CALC_5,0,'','-')   || "+ 
						              "DECODE(DL.DOLE_SEM_CONT_CALC_5,0,'', "+
						              "SUBSTR(TO_CHAR(DL.DOLE_SEM_CONT_CALC_5),5,1)), "+
						              "NVL(DL.DOLE_CONT_CALC_5,0), "+
						              "DECODE(DL.DOLE_SEM_CONT_CALC_6,0,0, "+
						              "SUBSTR(TO_CHAR(DL.DOLE_SEM_CONT_CALC_6),1,4))|| "+
						              "DECODE(DL.DOLE_SEM_CONT_CALC_6,0,'','-')   || "+ 
						              "DECODE(DL.DOLE_SEM_CONT_CALC_6,0,'', "+
						              "SUBSTR(TO_CHAR(DL.DOLE_SEM_CONT_CALC_6),5,1)), "+
						              "NVL(DL.DOLE_CONT_CALC_6,0), "+
						              "DECODE(DL.DOLE_SEM_CONT_CALC_7,0,0, "+
						              "SUBSTR(TO_CHAR(DL.DOLE_SEM_CONT_CALC_7),1,4))|| "+
						              "DECODE(DL.DOLE_SEM_CONT_CALC_7,0,'','-')   || "+ 
						              "DECODE(DL.DOLE_SEM_CONT_CALC_7,0,'', "+
						              "SUBSTR(TO_CHAR(DL.DOLE_SEM_CONT_CALC_7),5,1)), "+
						              "NVL(DL.DOLE_CONT_CALC_7,0), "+
						              "NVL(TO_CHAR(DL.DOLE_FEC_FIRMA,'DD.MM.YYYY'),' ') "+
						           "FROM BR_DETS_LEGAL DL,"+
						               "GLO_UNIDADES_ORGANIZACIONALES UO,"+
						               "GLO_COMUNAS C1,"+
						               "GLO_COMUNAS C2,"+
						               "GLO_COMUNAS C3,"+
						               "BR_UNIDADES_NEGOCIO UN "+
						           "WHERE "+
						            "DL.DOLE_NRO_PROCESO = '716' AND "+                  
						            "UO.CODIGO = DL.DOLE_UNIDAD_PADRE AND "+
						            "C1.CODIGO_CONARA_SII = DL.DOLE_COMUNA_ACTUAL  AND "+
						            "UN.UNNE_TIUN_CODIGO = 4  AND "+
						            "UN.UNNE_CODIGO = UO.CODIGO  AND "+
						            "C2.CODIGO_CONARA_SII = UN.UNNE_COMU_CODIGO_CONARA_SII "+
						            "AND C3.CODIGO_CONARA_SII = DL.COMU_CODIGO_POSTAL "+
						            "and ROWNUM <= 1 "+
						            "ORDER BY DL.DOLE_COMUNA_ACTUAL, DL.DOLE_MANZANA_ACTUAL,"+
						            "DL.DOLE_PREDIO_ACTUAL,DL.DOLE_NUM_RES_IMPRESA";
						query = conn.prepareStatement(sql);
						
						
						
						
						
						//query.setString(1, brand.toUpperCase()); //protect against sql injection
						ResultSet rs = query.executeQuery();
						
						
						//for(i=0, i<=rs.get){
								
								while (rs.next()){
									feaObj.setDOLE_AGNO(rs.getString(4));
									feaObj.setDOLE_REGIONAL(rs.getString(3));
									feaObj.setAge(rs.getRow());
									feaObj.setName("Java");
									fea.add(feaObj);
									System.out.println("numero "+fea.size());
									System.out.println("Dole Regional: "+feaObj.getDOLE_REGIONAL() +" Ano: "+ feaObj.getDOLE_AGNO());
									
								}
						//}
						
						
						
						
						
						//json = converter.toJSONArray(rs);
						query.close(); //close connection
					}
					catch(SQLException sqlError) {
						sqlError.printStackTrace();
						return fea;
					}
					catch(Exception e) {
						e.printStackTrace();
						return fea;
					}
					finally {
						if (conn != null) conn.close();
					}
					
					return fea;
				}
				
	
	
	
	
}
