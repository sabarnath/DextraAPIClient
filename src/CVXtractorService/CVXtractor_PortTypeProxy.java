package CVXtractorService;

public class CVXtractor_PortTypeProxy implements CVXtractorService.CVXtractor_PortType {
  private String _endpoint = null;
  private CVXtractorService.CVXtractor_PortType cVXtractor_PortType = null;
  
  public CVXtractor_PortTypeProxy() {
    _initCVXtractor_PortTypeProxy();
  }
  
  public CVXtractor_PortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initCVXtractor_PortTypeProxy();
  }
  
  private void _initCVXtractor_PortTypeProxy() {
    try {
      cVXtractor_PortType = (new CVXtractorService.CVXtractor_ServiceLocator()).getCVXtractor_Port();
      if (cVXtractor_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cVXtractor_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cVXtractor_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cVXtractor_PortType != null)
      ((javax.xml.rpc.Stub)cVXtractor_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public CVXtractorService.CVXtractor_PortType getCVXtractor_PortType() {
    if (cVXtractor_PortType == null)
      _initCVXtractor_PortTypeProxy();
    return cVXtractor_PortType;
  }
  
  public java.lang.String processCVattach(java.lang.String account, org.apache.axis.attachments.OctetStream CVattachment) throws java.rmi.RemoteException{
    if (cVXtractor_PortType == null)
      _initCVXtractor_PortTypeProxy();
    return cVXtractor_PortType.processCVattach(account, CVattachment);
  }
  
  public void processCVphase1Attach(java.lang.String account, org.apache.axis.attachments.OctetStream CVattachment, javax.xml.rpc.holders.StringHolder hrxml, javax.xml.rpc.holders.StringHolder phase2_token) throws java.rmi.RemoteException{
    if (cVXtractor_PortType == null)
      _initCVXtractor_PortTypeProxy();
    cVXtractor_PortType.processCVphase1Attach(account, CVattachment, hrxml, phase2_token);
  }
  
  public java.lang.String processCV(byte[] document_url, java.lang.String account) throws java.rmi.RemoteException{
    if (cVXtractor_PortType == null)
      _initCVXtractor_PortTypeProxy();
    return cVXtractor_PortType.processCV(document_url, account);
  }
  
  public void processCVphase1(byte[] document_url, java.lang.String account, javax.xml.rpc.holders.StringHolder hrxml, javax.xml.rpc.holders.StringHolder phase2_token) throws java.rmi.RemoteException{
    if (cVXtractor_PortType == null)
      _initCVXtractor_PortTypeProxy();
    cVXtractor_PortType.processCVphase1(document_url, account, hrxml, phase2_token);
  }
  
  public java.lang.String processCVphase2(java.lang.String phase2_token, java.lang.String account) throws java.rmi.RemoteException{
    if (cVXtractor_PortType == null)
      _initCVXtractor_PortTypeProxy();
    return cVXtractor_PortType.processCVphase2(phase2_token, account);
  }
  
  public java.lang.String processJobOrder(byte[] document_url, java.lang.String account) throws java.rmi.RemoteException{
    if (cVXtractor_PortType == null)
      _initCVXtractor_PortTypeProxy();
    return cVXtractor_PortType.processJobOrder(document_url, account);
  }
  
  public java.lang.String processJobOrderAttach(java.lang.String account, org.apache.axis.attachments.OctetStream JOattachment) throws java.rmi.RemoteException{
    if (cVXtractor_PortType == null)
      _initCVXtractor_PortTypeProxy();
    return cVXtractor_PortType.processJobOrderAttach(account, JOattachment);
  }
  
  public java.lang.String convertCV(byte[] document_url, java.lang.String account) throws java.rmi.RemoteException{
    if (cVXtractor_PortType == null)
      _initCVXtractor_PortTypeProxy();
    return cVXtractor_PortType.convertCV(document_url, account);
  }
  
  public byte[] reformatCV(byte[] document_url, java.lang.String account, java.lang.String template, java.lang.String hrxml) throws java.rmi.RemoteException{
    if (cVXtractor_PortType == null)
      _initCVXtractor_PortTypeProxy();
    return cVXtractor_PortType.reformatCV(document_url, account, template, hrxml);
  }
  
  public byte[] PDF2Word(byte[] document_url, java.lang.String account) throws java.rmi.RemoteException{
    if (cVXtractor_PortType == null)
      _initCVXtractor_PortTypeProxy();
    return cVXtractor_PortType.PDF2Word(document_url, account);
  }
  
  public void processBatch(byte[] document_url, java.lang.String account, javax.xml.rpc.holders.ByteArrayHolder results, javax.xml.rpc.holders.StringHolder process_token) throws java.rmi.RemoteException{
    if (cVXtractor_PortType == null)
      _initCVXtractor_PortTypeProxy();
    cVXtractor_PortType.processBatch(document_url, account, results, process_token);
  }
  
  public java.lang.String installLists(java.lang.String list_type, java.lang.String account, java.lang.String list_content) throws java.rmi.RemoteException{
    if (cVXtractor_PortType == null)
      _initCVXtractor_PortTypeProxy();
    return cVXtractor_PortType.installLists(list_type, account, list_content);
  }
  
  public java.lang.String retrieveLists(java.lang.String list_type, java.lang.String account) throws java.rmi.RemoteException{
    if (cVXtractor_PortType == null)
      _initCVXtractor_PortTypeProxy();
    return cVXtractor_PortType.retrieveLists(list_type, account);
  }
  
  public java.lang.String createAccount(java.lang.String account, java.lang.String credentials) throws java.rmi.RemoteException{
    if (cVXtractor_PortType == null)
      _initCVXtractor_PortTypeProxy();
    return cVXtractor_PortType.createAccount(account, credentials);
  }
  
  
}