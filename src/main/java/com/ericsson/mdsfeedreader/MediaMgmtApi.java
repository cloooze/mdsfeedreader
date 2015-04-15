package com.ericsson.mdsfeedreader;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;

import com.drutt.ws.msdp.media.management.v3.Asset;
import com.drutt.ws.msdp.media.management.v3.IncludeItems;
import com.drutt.ws.msdp.media.management.v3.MediaManagementApi;
import com.drutt.ws.msdp.media.management.v3.MediaManagementService;
import com.drutt.ws.msdp.media.management.v3.Meta;
import com.drutt.ws.msdp.media.management.v3.SortItem;
import com.drutt.ws.msdp.media.management.v3.WSException_Exception;
import com.drutt.ws.msdp.media.management.v3.WriteAsset;
import com.ericsson.mdsfeedreader.enums.Brand;
import com.ericsson.mdsfeedreader.util.DateUtil;
import com.ericsson.mdsfeedreader.util.MsdpProperties;


public class MediaMgmtApi {
	
	private static MediaMgmtApi mediaMgmtApi= null;
	private MediaManagementService mediaService = null;
	private MediaManagementApi mediaApi = null;
	
	private final static String DISCOUNT_providerId = MsdpProperties.getDefinition("mdsp.media.discount.providerid");
	private final static String DISCOUNT_serviceId = MsdpProperties.getDefinition("mdsp.media.discount.serviceid");
	private final static String PHONE_providerId = MsdpProperties.getDefinition("mdsp.media.phone.providerid");
	private final static String PHONE_serviceId = MsdpProperties.getDefinition("mdsp.media.phone.serviceid");
	
//	
	private static final String MSDP_ENDPOINT = MsdpProperties.getDefinition("msdp.media.api.endpoint");
	private static final String MSDP_API_USERNAME = MsdpProperties.getDefinition("msdp.media.api.username");
	private static final String MSDP_API_PASSWORD = MsdpProperties.getDefinition("msdp.media.api.password");
	
	protected static MediaMgmtApi getInstance() {
		if (mediaMgmtApi == null) {
			return new MediaMgmtApi();
		}
		else 
			return mediaMgmtApi;
	}
	
	protected MediaMgmtApi () {
		try {
			mediaService = new MediaManagementService(new URL(MSDP_ENDPOINT));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		mediaApi = mediaService.getMediaMngServiceImplPort();
		
		Map<String, Object> requestContext = ((BindingProvider)mediaApi).getRequestContext();
		
//		requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, MSDP_ENDPOINT);
		requestContext.put(BindingProvider.USERNAME_PROPERTY, MSDP_API_USERNAME);
		requestContext.put(BindingProvider.PASSWORD_PROPERTY, MSDP_API_PASSWORD);
	}
	
	public static List<Asset> getAssetByExternalId(String externalId, String providerId) throws WSException_Exception {
		SortItem sortItem = new SortItem();
		sortItem.setField("creation");
		sortItem.setOrder("ASC");
		
		IncludeItems includeItems = new IncludeItems();

		includeItems.setNbrItems(5);
		includeItems.setSort(sortItem);
		
		List<String> skus = new ArrayList<String>();
		skus.add(externalId);
		
		return getInstance().getMediaApi().getAssetsByExternalAssetId(providerId, skus, includeItems);
	}
	
	public static void updateAssetDiscountMeta(String externalId, String metaKey, String metaValue) throws WSException_Exception {
		List<Asset> listAsset = getAssetByExternalId(externalId, DISCOUNT_providerId);
		
		Asset asset = listAsset.get(0);
		
		updateAsset(asset, metaKey, metaValue);
	}
	
	public static void updateAssetPhoneMeta(String externalId, String metaKey, String metaValue) throws WSException_Exception {
		List<Asset> listAsset = getAssetByExternalId(externalId, PHONE_providerId);
		
		Asset asset = listAsset.get(0);
		
		updateAsset(asset, metaKey, metaValue);
	}
	
	private static List<Asset> updateAsset(Asset asset, String metaKey, String metaValue) throws WSException_Exception {
		List<WriteAsset> listWriteAsset = new ArrayList<WriteAsset>();
		WriteAsset writeAsset = new WriteAsset();
		
		
		writeAsset.setAssetId(asset.getAssetId());
		writeAsset.setProviderId(asset.getProviderId());
		writeAsset.setServiceId(asset.getServiceId());
		writeAsset.setType(asset.getType());
		writeAsset.setDeployed(true);
		writeAsset.setOwnerAssetId(asset.getOwnerAssetId());
		
		boolean found = false;
		
		if (metaKey != null && !metaKey.isEmpty()) {
			for (Meta meta : asset.getMeta()) {
				if (meta.getKey().equalsIgnoreCase(metaKey)) {
					meta.setValue(metaValue);
					found = true;
				}
			}
		}
		
		if (!found) {
			Meta m = new Meta();
			m.setKey(metaKey);
			m.setValue(metaValue);
			asset.getMeta().add(m);
		}
		
		writeAsset.getMeta().addAll(asset.getMeta());
		
		listWriteAsset.add(writeAsset);
		
		return getInstance().getMediaApi().updateAssets(listWriteAsset, false);
	}
	
	public static List<Asset> updateMetaStartTime(String externalId, String startTime) throws WSException_Exception, DatatypeConfigurationException, ParseException {
		Asset asset = getAssetByExternalId(externalId, DISCOUNT_providerId).get(0);
		
		List<WriteAsset> listWriteAsset = new ArrayList<WriteAsset>();
		WriteAsset writeAsset = new WriteAsset();
		
		
		writeAsset.setAssetId(asset.getAssetId());
		writeAsset.setProviderId(asset.getProviderId());
		writeAsset.setServiceId(asset.getServiceId());
		writeAsset.setType(asset.getType());
		writeAsset.setDeployed(true);
		writeAsset.setOwnerAssetId(asset.getOwnerAssetId());
		writeAsset.getMeta().addAll(asset.getMeta());
		
		writeAsset.setStartTime(DateUtil.getXMLGregorianCalendar(startTime));
		
		listWriteAsset.add(writeAsset);
		
		return getInstance().getMediaApi().updateAssets(listWriteAsset, false);
	}
	
	public static List<Asset> updateMetaValidUntil(String externalId, String validUntil) throws WSException_Exception, DatatypeConfigurationException, ParseException {
		Asset asset = getAssetByExternalId(externalId, DISCOUNT_providerId).get(0);
		
		List<WriteAsset> listWriteAsset = new ArrayList<WriteAsset>();
		WriteAsset writeAsset = new WriteAsset();
		
		
		writeAsset.setAssetId(asset.getAssetId());
		writeAsset.setProviderId(asset.getProviderId());
		writeAsset.setServiceId(asset.getServiceId());
		writeAsset.setType(asset.getType());
		writeAsset.setDeployed(true);
		writeAsset.setOwnerAssetId(asset.getOwnerAssetId());
		writeAsset.getMeta().addAll(asset.getMeta());
		
		writeAsset.setValidUntil(DateUtil.getXMLGregorianCalendar(validUntil));
		
		listWriteAsset.add(writeAsset);
		
		return getInstance().getMediaApi().updateAssets(listWriteAsset, false);
	}
	
	public static boolean createNewAsset(String externalId, String name, Brand brandId, String description, String effDate, String eqp, String productSet, String type) throws DatatypeConfigurationException, ParseException, WSException_Exception {
		List<WriteAsset> assetList = new ArrayList<WriteAsset>();
		
		WriteAsset writeAsset = new WriteAsset();
		writeAsset.setDeployed(true);
		writeAsset.setServiceId(DISCOUNT_serviceId);
//		writeAsset.setAssetId(externalId);
		writeAsset.setOwnerAssetId(externalId);
		writeAsset.setProviderId(DISCOUNT_providerId);
		writeAsset.setType(type);
		writeAsset.setStartTime(DateUtil.getXMLGregorianCalendar(effDate));
		
		List<Meta> metaList = writeAsset.getMeta();
		
		Meta meta = new Meta();
		meta.setKey("brandId");
		meta.setValue(brandId.toString());
		
		metaList.add(meta);
		
		meta = new Meta();
		meta.setKey("sku");
		meta.setValue(externalId);
		
		metaList.add(meta);
		
		meta = new Meta();
		meta.setKey("name");
		meta.setValue("name");
		
		metaList.add(meta);
		
		meta = new Meta();
		meta.setKey("eqp");
		meta.setValue(eqp);
		
		metaList.add(meta);
		
		meta = new Meta();
		meta.setKey("effectiveDate");
		meta.setValue(effDate);
		
		metaList.add(meta);
		
		meta = new Meta();
		meta.setKey("productSet");
		meta.setValue(productSet);
		
		metaList.add(meta);
		
		meta = new Meta();
		meta.setKey("description");
		meta.setValue(description);
		
		metaList.add(meta);
		
		assetList.add(writeAsset);
		
		getInstance().getMediaApi().createAssets(assetList, false);
		
		return true;
	}
	
	public MediaManagementApi getMediaApi() {
		return mediaApi;
	}
	
}
