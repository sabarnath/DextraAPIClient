/**
 * CVXtractor_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package CVXtractorService;

public interface CVXtractor_PortType extends java.rmi.Remote {
    public java.lang.String processCVattach(java.lang.String account, org.apache.axis.attachments.OctetStream CVattachment) throws java.rmi.RemoteException;
    public void processCVphase1Attach(java.lang.String account, org.apache.axis.attachments.OctetStream CVattachment, javax.xml.rpc.holders.StringHolder hrxml, javax.xml.rpc.holders.StringHolder phase2_token) throws java.rmi.RemoteException;
    public java.lang.String processCV(byte[] document_url, java.lang.String account) throws java.rmi.RemoteException;
    public void processCVphase1(byte[] document_url, java.lang.String account, javax.xml.rpc.holders.StringHolder hrxml, javax.xml.rpc.holders.StringHolder phase2_token) throws java.rmi.RemoteException;
    public java.lang.String processCVphase2(java.lang.String phase2_token, java.lang.String account) throws java.rmi.RemoteException;
    public java.lang.String processJobOrder(byte[] document_url, java.lang.String account) throws java.rmi.RemoteException;
    public java.lang.String processJobOrderAttach(java.lang.String account, org.apache.axis.attachments.OctetStream JOattachment) throws java.rmi.RemoteException;
    public java.lang.String convertCV(byte[] document_url, java.lang.String account) throws java.rmi.RemoteException;
    public byte[] reformatCV(byte[] document_url, java.lang.String account, java.lang.String template, java.lang.String hrxml) throws java.rmi.RemoteException;
    public byte[] PDF2Word(byte[] document_url, java.lang.String account) throws java.rmi.RemoteException;
    public void processBatch(byte[] document_url, java.lang.String account, javax.xml.rpc.holders.ByteArrayHolder results, javax.xml.rpc.holders.StringHolder process_token) throws java.rmi.RemoteException;
    public java.lang.String installLists(java.lang.String list_type, java.lang.String account, java.lang.String list_content) throws java.rmi.RemoteException;
    public java.lang.String retrieveLists(java.lang.String list_type, java.lang.String account) throws java.rmi.RemoteException;
    public java.lang.String createAccount(java.lang.String account, java.lang.String credentials) throws java.rmi.RemoteException;
}
