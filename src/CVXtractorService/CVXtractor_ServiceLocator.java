/**
 * CVXtractor_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package CVXtractorService;

public class CVXtractor_ServiceLocator extends org.apache.axis.client.Service implements CVXtractorService.CVXtractor_Service {

/**
 * WSDL File for CVXtractorService
 */

    public CVXtractor_ServiceLocator() {
    }


    public CVXtractor_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CVXtractor_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CVXtractor_Port
    private java.lang.String CVXtractor_Port_address = "http://52.91.84.95/cvx/soap";

    public java.lang.String getCVXtractor_PortAddress() {
        return CVXtractor_Port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CVXtractor_PortWSDDServiceName = "CVXtractor_Port";

    public java.lang.String getCVXtractor_PortWSDDServiceName() {
        return CVXtractor_PortWSDDServiceName;
    }

    public void setCVXtractor_PortWSDDServiceName(java.lang.String name) {
        CVXtractor_PortWSDDServiceName = name;
    }

    public CVXtractorService.CVXtractor_PortType getCVXtractor_Port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CVXtractor_Port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCVXtractor_Port(endpoint);
    }

    public CVXtractorService.CVXtractor_PortType getCVXtractor_Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            CVXtractorService.CVXtractor_BindingStub _stub = new CVXtractorService.CVXtractor_BindingStub(portAddress, this);
            _stub.setPortName(getCVXtractor_PortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCVXtractor_PortEndpointAddress(java.lang.String address) {
        CVXtractor_Port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (CVXtractorService.CVXtractor_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                CVXtractorService.CVXtractor_BindingStub _stub = new CVXtractorService.CVXtractor_BindingStub(new java.net.URL(CVXtractor_Port_address), this);
                _stub.setPortName(getCVXtractor_PortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CVXtractor_Port".equals(inputPortName)) {
            return getCVXtractor_Port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("CVXtractorService", "CVXtractor_Service");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("CVXtractorService", "CVXtractor_Port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CVXtractor_Port".equals(portName)) {
            setCVXtractor_PortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
