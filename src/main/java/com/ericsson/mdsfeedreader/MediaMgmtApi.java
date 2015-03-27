package com.ericsson.mdsfeedreader;

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
import com.ericsson.mdsfeedreader.util.DateUtil;
import com.ericsson.mdsfeedreader.util.MsdpProperties;


public class MediaMgmtApi {
	
	private static MediaMgmtApi mediaMgmtApi= null;
	private MediaManagementService mediaService = null;
	private MediaManagementApi mediaApi = null;
	
	private final static String providerId = MsdpProperties.getDefinition("mdsp.media.providerid");
	
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
		mediaService = new MediaManagementService();
		
		mediaApi = mediaService.getMediaMngServiceImplPort();
		
		Map<String, Object> requestContext = ((BindingProvider)mediaApi).getRequestContext();
		
		requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, MSDP_ENDPOINT);
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
	
	public static void updateAssetMeta(String externalId, String metaKey, String metaValue) throws WSException_Exception {
		List<Asset> listAsset = getAssetByExternalId(externalId, providerId);
		
		Asset asset = listAsset.get(0);
		
		updateAsset(asset, metaKey, metaValue);
	}
	
	public static List<Asset> updateAsset(Asset asset, String metaKey, String metaValue) throws WSException_Exception {
		List<WriteAsset> listWriteAsset = new ArrayList<WriteAsset>();
		WriteAsset writeAsset = new WriteAsset();
		
		
		writeAsset.setAssetId(asset.getAssetId());
		writeAsset.setProviderId(asset.getProviderId());
		writeAsset.setServiceId(asset.getServiceId());
		writeAsset.setType(asset.getType());
		writeAsset.setDeployed(true);
		writeAsset.setOwnerAssetId(asset.getOwnerAssetId());
		
		if (metaKey != null && !metaKey.isEmpty()) {
			for (Meta meta : asset.getMeta()) {
				if (meta.getKey().equalsIgnoreCase(metaKey)) {
					meta.setValue(metaValue);
				}
			}
		}
		writeAsset.getMeta().addAll(asset.getMeta());
		
		listWriteAsset.add(writeAsset);
		
		return getInstance().getMediaApi().updateAssets(listWriteAsset, false);
	}
	
	@Deprecated
	public static List<Asset> updateAssetDefaultField(String externalId, String startTime) throws WSException_Exception, DatatypeConfigurationException, ParseException {
		Asset asset = getAssetByExternalId(externalId, providerId).get(0);
		
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
	
	public MediaManagementApi getMediaApi() {
		return mediaApi;
	}
	
}
