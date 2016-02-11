package com.ec.tvcable.switchaprov.AprovDTH;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.6
 * 2016-02-11T10:56:25.782-05:00
 * Generated source version: 2.6.6
 * 
 */
@WebService(targetNamespace = "http://tempuri.org/", name = "TvCableIntegrationServiceInternalSoap")
@XmlSeeAlso({ObjectFactory.class})
public interface TvCableIntegrationServiceInternalSoap {

    @WebResult(name = "AddCarrierResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "AddCarrier", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.AddCarrier")
    @WebMethod(operationName = "AddCarrier", action = "http://tempuri.org/AddCarrier")
    @ResponseWrapper(localName = "AddCarrierResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.AddCarrierResponse")
    public java.lang.String addCarrier(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "carrier", targetNamespace = "http://tempuri.org/")
        java.lang.String carrier,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "GetSmartCardsInfoResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetSmartCardsInfo", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.GetSmartCardsInfo")
    @WebMethod(operationName = "GetSmartCardsInfo", action = "http://tempuri.org/GetSmartCardsInfo")
    @ResponseWrapper(localName = "GetSmartCardsInfoResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.GetSmartCardsInfoResponse")
    public java.lang.String getSmartCardsInfo(
        @WebParam(name = "usuario", targetNamespace = "http://tempuri.org/")
        java.lang.String usuario,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password
    );

    @WebResult(name = "StatusResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Status", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.Status")
    @WebMethod(operationName = "Status", action = "http://tempuri.org/Status")
    @ResponseWrapper(localName = "StatusResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.StatusResponse")
    public java.lang.String status(
        @WebParam(name = "usuario", targetNamespace = "http://tempuri.org/")
        java.lang.String usuario,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password
    );

    @WebResult(name = "ReScanChannelsResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ReScanChannels", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.ReScanChannels")
    @WebMethod(operationName = "ReScanChannels", action = "http://tempuri.org/ReScanChannels")
    @ResponseWrapper(localName = "ReScanChannelsResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.ReScanChannelsResponse")
    public java.lang.String reScanChannels(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "UpdateCodeZoneResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "UpdateCodeZone", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.UpdateCodeZone")
    @WebMethod(operationName = "UpdateCodeZone", action = "http://tempuri.org/UpdateCodeZone")
    @ResponseWrapper(localName = "UpdateCodeZoneResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.UpdateCodeZoneResponse")
    public java.lang.String updateCodeZone(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "code", targetNamespace = "http://tempuri.org/")
        java.lang.String code,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "UninstallResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Uninstall", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.Uninstall")
    @WebMethod(operationName = "Uninstall", action = "http://tempuri.org/Uninstall")
    @ResponseWrapper(localName = "UninstallResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.UninstallResponse")
    public java.lang.String uninstall(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "RemovePacksResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "RemovePacks", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.RemovePacks")
    @WebMethod(operationName = "RemovePacks", action = "http://tempuri.org/RemovePacks")
    @ResponseWrapper(localName = "RemovePacksResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.RemovePacksResponse")
    public java.lang.String removePacks(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "pack1", targetNamespace = "http://tempuri.org/")
        java.lang.String pack1,
        @WebParam(name = "pack2", targetNamespace = "http://tempuri.org/")
        java.lang.String pack2,
        @WebParam(name = "pack3", targetNamespace = "http://tempuri.org/")
        java.lang.String pack3,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "UpdateMenuPassResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "UpdateMenuPass", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.UpdateMenuPass")
    @WebMethod(operationName = "UpdateMenuPass", action = "http://tempuri.org/UpdateMenuPass")
    @ResponseWrapper(localName = "UpdateMenuPassResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.UpdateMenuPassResponse")
    public java.lang.String updateMenuPass(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "pin", targetNamespace = "http://tempuri.org/")
        java.lang.String pin,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "ResetSetTopBoxResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ResetSetTopBox", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.ResetSetTopBox")
    @WebMethod(operationName = "ResetSetTopBox", action = "http://tempuri.org/ResetSetTopBox")
    @ResponseWrapper(localName = "ResetSetTopBoxResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.ResetSetTopBoxResponse")
    public java.lang.String resetSetTopBox(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "AddPacksResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "AddPacks", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.AddPacks")
    @WebMethod(operationName = "AddPacks", action = "http://tempuri.org/AddPacks")
    @ResponseWrapper(localName = "AddPacksResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.AddPacksResponse")
    public java.lang.String addPacks(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "pack1", targetNamespace = "http://tempuri.org/")
        java.lang.String pack1,
        @WebParam(name = "pack2", targetNamespace = "http://tempuri.org/")
        java.lang.String pack2,
        @WebParam(name = "pack3", targetNamespace = "http://tempuri.org/")
        java.lang.String pack3,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "ForceUpdateFirmwareResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ForceUpdateFirmware", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.ForceUpdateFirmware")
    @WebMethod(operationName = "ForceUpdateFirmware", action = "http://tempuri.org/ForceUpdateFirmware")
    @ResponseWrapper(localName = "ForceUpdateFirmwareResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.ForceUpdateFirmwareResponse")
    public java.lang.String forceUpdateFirmware(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "DisconnectResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Disconnect", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.Disconnect")
    @WebMethod(operationName = "Disconnect", action = "http://tempuri.org/Disconnect")
    @ResponseWrapper(localName = "DisconnectResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.DisconnectResponse")
    public java.lang.String disconnect(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "ReSendKeyResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ReSendKey", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.ReSendKey")
    @WebMethod(operationName = "ReSendKey", action = "http://tempuri.org/ReSendKey")
    @ResponseWrapper(localName = "ReSendKeyResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.ReSendKeyResponse")
    public java.lang.String reSendKey(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "RebootSetTopBoxResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "RebootSetTopBox", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.RebootSetTopBox")
    @WebMethod(operationName = "RebootSetTopBox", action = "http://tempuri.org/RebootSetTopBox")
    @ResponseWrapper(localName = "RebootSetTopBoxResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.RebootSetTopBoxResponse")
    public java.lang.String rebootSetTopBox(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "UpdateFirmwareResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "UpdateFirmware", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.UpdateFirmware")
    @WebMethod(operationName = "UpdateFirmware", action = "http://tempuri.org/UpdateFirmware")
    @ResponseWrapper(localName = "UpdateFirmwareResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.UpdateFirmwareResponse")
    public java.lang.String updateFirmware(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "SendMessageResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "SendMessage", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.SendMessage")
    @WebMethod(operationName = "SendMessage", action = "http://tempuri.org/SendMessage")
    @ResponseWrapper(localName = "SendMessageResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.SendMessageResponse")
    public java.lang.String sendMessage(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "message", targetNamespace = "http://tempuri.org/")
        java.lang.String message,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "InstallResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Install", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.Install")
    @WebMethod(operationName = "Install", action = "http://tempuri.org/Install")
    @ResponseWrapper(localName = "InstallResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.InstallResponse")
    public java.lang.String install(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "codeSettopBox", targetNamespace = "http://tempuri.org/")
        java.lang.String codeSettopBox,
        @WebParam(name = "brandSettopBox", targetNamespace = "http://tempuri.org/")
        java.lang.String brandSettopBox,
        @WebParam(name = "modelSettopBox", targetNamespace = "http://tempuri.org/")
        java.lang.String modelSettopBox,
        @WebParam(name = "firmwareSettopBox", targetNamespace = "http://tempuri.org/")
        java.lang.String firmwareSettopBox,
        @WebParam(name = "pack1", targetNamespace = "http://tempuri.org/")
        java.lang.String pack1,
        @WebParam(name = "pack2", targetNamespace = "http://tempuri.org/")
        java.lang.String pack2,
        @WebParam(name = "pack3", targetNamespace = "http://tempuri.org/")
        java.lang.String pack3,
        @WebParam(name = "masterCard", targetNamespace = "http://tempuri.org/")
        java.lang.String masterCard,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "ReconnectResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Reconnect", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.Reconnect")
    @WebMethod(operationName = "Reconnect", action = "http://tempuri.org/Reconnect")
    @ResponseWrapper(localName = "ReconnectResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.ReconnectResponse")
    public java.lang.String reconnect(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "pack1", targetNamespace = "http://tempuri.org/")
        java.lang.String pack1,
        @WebParam(name = "pack2", targetNamespace = "http://tempuri.org/")
        java.lang.String pack2,
        @WebParam(name = "pack3", targetNamespace = "http://tempuri.org/")
        java.lang.String pack3,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "UpdatePinResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "UpdatePin", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.UpdatePin")
    @WebMethod(operationName = "UpdatePin", action = "http://tempuri.org/UpdatePin")
    @ResponseWrapper(localName = "UpdatePinResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.UpdatePinResponse")
    public java.lang.String updatePin(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "pin", targetNamespace = "http://tempuri.org/")
        java.lang.String pin,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "UpdateControlParentallResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "UpdateControlParentall", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.UpdateControlParentall")
    @WebMethod(operationName = "UpdateControlParentall", action = "http://tempuri.org/UpdateControlParentall")
    @ResponseWrapper(localName = "UpdateControlParentallResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.UpdateControlParentallResponse")
    public java.lang.String updateControlParentall(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "pin", targetNamespace = "http://tempuri.org/")
        java.lang.String pin,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "GetInformationResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetInformation", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.GetInformation")
    @WebMethod(operationName = "GetInformation", action = "http://tempuri.org/GetInformation")
    @ResponseWrapper(localName = "GetInformationResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.GetInformationResponse")
    public java.lang.String getInformation(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );

    @WebResult(name = "ViewSetTopBoxIDResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ViewSetTopBoxID", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.ViewSetTopBoxID")
    @WebMethod(operationName = "ViewSetTopBoxID", action = "http://tempuri.org/ViewSetTopBoxID")
    @ResponseWrapper(localName = "ViewSetTopBoxIDResponse", targetNamespace = "http://tempuri.org/", className = "com.ec.tvcable.switchaprov.AprovDTH.ViewSetTopBoxIDResponse")
    public java.lang.String viewSetTopBoxID(
        @WebParam(name = "userName", targetNamespace = "http://tempuri.org/")
        java.lang.String userName,
        @WebParam(name = "password", targetNamespace = "http://tempuri.org/")
        java.lang.String password,
        @WebParam(name = "sequence", targetNamespace = "http://tempuri.org/")
        java.lang.String sequence,
        @WebParam(name = "smartCards", targetNamespace = "http://tempuri.org/")
        java.lang.String smartCards,
        @WebParam(name = "userId", targetNamespace = "http://tempuri.org/")
        java.lang.String userId,
        @WebParam(name = "referenceNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String referenceNumber,
        @WebParam(name = "notes", targetNamespace = "http://tempuri.org/")
        java.lang.String notes,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "zone", targetNamespace = "http://tempuri.org/")
        java.lang.String zone
    );
}