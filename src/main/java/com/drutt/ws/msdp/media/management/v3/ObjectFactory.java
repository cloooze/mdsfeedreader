
package com.drutt.ws.msdp.media.management.v3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.drutt.ws.msdp.media.management.v3 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteCategories_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "deleteCategories");
    private final static QName _CreateItemsResponse_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "createItemsResponse");
    private final static QName _UpdateItems_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "updateItems");
    private final static QName _SearchItems_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "searchItems");
    private final static QName _DeleteAssetsResponse_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "deleteAssetsResponse");
    private final static QName _CreateCategoriesResponse_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "createCategoriesResponse");
    private final static QName _GetAssetsByIdKey_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "getAssetsByIdKey");
    private final static QName _GetAssetsResponse_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "getAssetsResponse");
    private final static QName _GetAssetsByAssetId_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "getAssetsByAssetId");
    private final static QName _SearchItemsResponse_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "searchItemsResponse");
    private final static QName _DeleteItemsResponse_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "deleteItemsResponse");
    private final static QName _UpdateAssets_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "updateAssets");
    private final static QName _DeleteGroups_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "deleteGroups");
    private final static QName _UpdateCategories_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "updateCategories");
    private final static QName _UpdateCategoriesResponse_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "updateCategoriesResponse");
    private final static QName _UpdateItemsResponse_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "updateItemsResponse");
    private final static QName _CreateAssets_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "createAssets");
    private final static QName _CreateGroupsResponse_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "createGroupsResponse");
    private final static QName _DeleteGroupsResponse_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "deleteGroupsResponse");
    private final static QName _DeleteAssets_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "deleteAssets");
    private final static QName _CreateGroups_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "createGroups");
    private final static QName _CreateItems_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "createItems");
    private final static QName _WSException_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "WSException");
    private final static QName _UpdateGroups_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "updateGroups");
    private final static QName _CreateCategories_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "createCategories");
    private final static QName _UpdateAssetsResponse_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "updateAssetsResponse");
    private final static QName _GetCategoriesByIdKey_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "getCategoriesByIdKey");
    private final static QName _GetCategoriesByCategoryId_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "getCategoriesByCategoryId");
    private final static QName _UpdateGroupsResponse_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "updateGroupsResponse");
    private final static QName _DeleteItems_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "deleteItems");
    private final static QName _CreateAssetsResponse_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "createAssetsResponse");
    private final static QName _GetCategoriesResponse_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "getCategoriesResponse");
    private final static QName _GetAssetsByExternalAssetId_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "getAssetsByExternalAssetId");
    private final static QName _DeleteCategoriesResponse_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "deleteCategoriesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.drutt.ws.msdp.media.management.v3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WriteAsset }
     * 
     */
    public WriteAsset createWriteAsset() {
        return new WriteAsset();
    }

    /**
     * Create an instance of {@link GetCategoriesByCategoryId }
     * 
     */
    public GetCategoriesByCategoryId createGetCategoriesByCategoryId() {
        return new GetCategoriesByCategoryId();
    }

    /**
     * Create an instance of {@link GetCategoriesByIdKey }
     * 
     */
    public GetCategoriesByIdKey createGetCategoriesByIdKey() {
        return new GetCategoriesByIdKey();
    }

    /**
     * Create an instance of {@link AssetsResponse }
     * 
     */
    public AssetsResponse createAssetsResponse() {
        return new AssetsResponse();
    }

    /**
     * Create an instance of {@link GroupsResponse }
     * 
     */
    public GroupsResponse createGroupsResponse() {
        return new GroupsResponse();
    }

    /**
     * Create an instance of {@link CategoriesResponse }
     * 
     */
    public CategoriesResponse createCategoriesResponse() {
        return new CategoriesResponse();
    }

    /**
     * Create an instance of {@link DeleteItems }
     * 
     */
    public DeleteItems createDeleteItems() {
        return new DeleteItems();
    }

    /**
     * Create an instance of {@link EmptyResponse }
     * 
     */
    public EmptyResponse createEmptyResponse() {
        return new EmptyResponse();
    }

    /**
     * Create an instance of {@link GetAssetsByExternalAssetId }
     * 
     */
    public GetAssetsByExternalAssetId createGetAssetsByExternalAssetId() {
        return new GetAssetsByExternalAssetId();
    }

    /**
     * Create an instance of {@link SearchItems }
     * 
     */
    public SearchItems createSearchItems() {
        return new SearchItems();
    }

    /**
     * Create an instance of {@link ItemsResponse }
     * 
     */
    public ItemsResponse createItemsResponse() {
        return new ItemsResponse();
    }

    /**
     * Create an instance of {@link WriteItems }
     * 
     */
    public WriteItems createWriteItems() {
        return new WriteItems();
    }

    /**
     * Create an instance of {@link DeleteCategories }
     * 
     */
    public DeleteCategories createDeleteCategories() {
        return new DeleteCategories();
    }

    /**
     * Create an instance of {@link GetAssetsByIdKey }
     * 
     */
    public GetAssetsByIdKey createGetAssetsByIdKey() {
        return new GetAssetsByIdKey();
    }

    /**
     * Create an instance of {@link GetAssetsByAssetId }
     * 
     */
    public GetAssetsByAssetId createGetAssetsByAssetId() {
        return new GetAssetsByAssetId();
    }

    /**
     * Create an instance of {@link WriteCategories }
     * 
     */
    public WriteCategories createWriteCategories() {
        return new WriteCategories();
    }

    /**
     * Create an instance of {@link SearchItemsResponse }
     * 
     */
    public SearchItemsResponse createSearchItemsResponse() {
        return new SearchItemsResponse();
    }

    /**
     * Create an instance of {@link WriteAssets }
     * 
     */
    public WriteAssets createWriteAssets() {
        return new WriteAssets();
    }

    /**
     * Create an instance of {@link DeleteGroups }
     * 
     */
    public DeleteGroups createDeleteGroups() {
        return new DeleteGroups();
    }

    /**
     * Create an instance of {@link WriteGroups }
     * 
     */
    public WriteGroups createWriteGroups() {
        return new WriteGroups();
    }

    /**
     * Create an instance of {@link WSException }
     * 
     */
    public WSException createWSException() {
        return new WSException();
    }

    /**
     * Create an instance of {@link DeleteAssets }
     * 
     */
    public DeleteAssets createDeleteAssets() {
        return new DeleteAssets();
    }

    /**
     * Create an instance of {@link PaginationInfo }
     * 
     */
    public PaginationInfo createPaginationInfo() {
        return new PaginationInfo();
    }

    /**
     * Create an instance of {@link WriteCategory }
     * 
     */
    public WriteCategory createWriteCategory() {
        return new WriteCategory();
    }

    /**
     * Create an instance of {@link WriteGroup }
     * 
     */
    public WriteGroup createWriteGroup() {
        return new WriteGroup();
    }

    /**
     * Create an instance of {@link SubItem }
     * 
     */
    public SubItem createSubItem() {
        return new SubItem();
    }

    /**
     * Create an instance of {@link BaseItem }
     * 
     */
    public BaseItem createBaseItem() {
        return new BaseItem();
    }

    /**
     * Create an instance of {@link Meta }
     * 
     */
    public Meta createMeta() {
        return new Meta();
    }

    /**
     * Create an instance of {@link BaseAsset }
     * 
     */
    public BaseAsset createBaseAsset() {
        return new BaseAsset();
    }

    /**
     * Create an instance of {@link Rule }
     * 
     */
    public Rule createRule() {
        return new Rule();
    }

    /**
     * Create an instance of {@link BaseRule }
     * 
     */
    public BaseRule createBaseRule() {
        return new BaseRule();
    }

    /**
     * Create an instance of {@link IncludeItems }
     * 
     */
    public IncludeItems createIncludeItems() {
        return new IncludeItems();
    }

    /**
     * Create an instance of {@link Asset }
     * 
     */
    public Asset createAsset() {
        return new Asset();
    }

    /**
     * Create an instance of {@link Rules }
     * 
     */
    public Rules createRules() {
        return new Rules();
    }

    /**
     * Create an instance of {@link com.drutt.ws.msdp.media.management.v3.Category }
     * 
     */
    public com.drutt.ws.msdp.media.management.v3.Category createCategory() {
        return new com.drutt.ws.msdp.media.management.v3.Category();
    }

    /**
     * Create an instance of {@link BaseGroup }
     * 
     */
    public BaseGroup createBaseGroup() {
        return new BaseGroup();
    }

    /**
     * Create an instance of {@link BaseCategory }
     * 
     */
    public BaseCategory createBaseCategory() {
        return new BaseCategory();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link PaginationResult }
     * 
     */
    public PaginationResult createPaginationResult() {
        return new PaginationResult();
    }

    /**
     * Create an instance of {@link Group }
     * 
     */
    public Group createGroup() {
        return new Group();
    }

    /**
     * Create an instance of {@link SortItem }
     * 
     */
    public SortItem createSortItem() {
        return new SortItem();
    }

    /**
     * Create an instance of {@link WriteAsset.Category }
     * 
     */
    public WriteAsset.Category createWriteAssetCategory() {
        return new WriteAsset.Category();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCategories }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "deleteCategories")
    public JAXBElement<DeleteCategories> createDeleteCategories(DeleteCategories value) {
        return new JAXBElement<DeleteCategories>(_DeleteCategories_QNAME, DeleteCategories.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "createItemsResponse")
    public JAXBElement<ItemsResponse> createCreateItemsResponse(ItemsResponse value) {
        return new JAXBElement<ItemsResponse>(_CreateItemsResponse_QNAME, ItemsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteItems }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "updateItems")
    public JAXBElement<WriteItems> createUpdateItems(WriteItems value) {
        return new JAXBElement<WriteItems>(_UpdateItems_QNAME, WriteItems.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchItems }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "searchItems")
    public JAXBElement<SearchItems> createSearchItems(SearchItems value) {
        return new JAXBElement<SearchItems>(_SearchItems_QNAME, SearchItems.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "deleteAssetsResponse")
    public JAXBElement<EmptyResponse> createDeleteAssetsResponse(EmptyResponse value) {
        return new JAXBElement<EmptyResponse>(_DeleteAssetsResponse_QNAME, EmptyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "createCategoriesResponse")
    public JAXBElement<CategoriesResponse> createCreateCategoriesResponse(CategoriesResponse value) {
        return new JAXBElement<CategoriesResponse>(_CreateCategoriesResponse_QNAME, CategoriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAssetsByIdKey }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "getAssetsByIdKey")
    public JAXBElement<GetAssetsByIdKey> createGetAssetsByIdKey(GetAssetsByIdKey value) {
        return new JAXBElement<GetAssetsByIdKey>(_GetAssetsByIdKey_QNAME, GetAssetsByIdKey.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssetsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "getAssetsResponse")
    public JAXBElement<AssetsResponse> createGetAssetsResponse(AssetsResponse value) {
        return new JAXBElement<AssetsResponse>(_GetAssetsResponse_QNAME, AssetsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAssetsByAssetId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "getAssetsByAssetId")
    public JAXBElement<GetAssetsByAssetId> createGetAssetsByAssetId(GetAssetsByAssetId value) {
        return new JAXBElement<GetAssetsByAssetId>(_GetAssetsByAssetId_QNAME, GetAssetsByAssetId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchItemsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "searchItemsResponse")
    public JAXBElement<SearchItemsResponse> createSearchItemsResponse(SearchItemsResponse value) {
        return new JAXBElement<SearchItemsResponse>(_SearchItemsResponse_QNAME, SearchItemsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "deleteItemsResponse")
    public JAXBElement<EmptyResponse> createDeleteItemsResponse(EmptyResponse value) {
        return new JAXBElement<EmptyResponse>(_DeleteItemsResponse_QNAME, EmptyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteAssets }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "updateAssets")
    public JAXBElement<WriteAssets> createUpdateAssets(WriteAssets value) {
        return new JAXBElement<WriteAssets>(_UpdateAssets_QNAME, WriteAssets.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteGroups }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "deleteGroups")
    public JAXBElement<DeleteGroups> createDeleteGroups(DeleteGroups value) {
        return new JAXBElement<DeleteGroups>(_DeleteGroups_QNAME, DeleteGroups.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteCategories }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "updateCategories")
    public JAXBElement<WriteCategories> createUpdateCategories(WriteCategories value) {
        return new JAXBElement<WriteCategories>(_UpdateCategories_QNAME, WriteCategories.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "updateCategoriesResponse")
    public JAXBElement<CategoriesResponse> createUpdateCategoriesResponse(CategoriesResponse value) {
        return new JAXBElement<CategoriesResponse>(_UpdateCategoriesResponse_QNAME, CategoriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "updateItemsResponse")
    public JAXBElement<ItemsResponse> createUpdateItemsResponse(ItemsResponse value) {
        return new JAXBElement<ItemsResponse>(_UpdateItemsResponse_QNAME, ItemsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteAssets }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "createAssets")
    public JAXBElement<WriteAssets> createCreateAssets(WriteAssets value) {
        return new JAXBElement<WriteAssets>(_CreateAssets_QNAME, WriteAssets.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GroupsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "createGroupsResponse")
    public JAXBElement<GroupsResponse> createCreateGroupsResponse(GroupsResponse value) {
        return new JAXBElement<GroupsResponse>(_CreateGroupsResponse_QNAME, GroupsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "deleteGroupsResponse")
    public JAXBElement<EmptyResponse> createDeleteGroupsResponse(EmptyResponse value) {
        return new JAXBElement<EmptyResponse>(_DeleteGroupsResponse_QNAME, EmptyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAssets }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "deleteAssets")
    public JAXBElement<DeleteAssets> createDeleteAssets(DeleteAssets value) {
        return new JAXBElement<DeleteAssets>(_DeleteAssets_QNAME, DeleteAssets.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteGroups }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "createGroups")
    public JAXBElement<WriteGroups> createCreateGroups(WriteGroups value) {
        return new JAXBElement<WriteGroups>(_CreateGroups_QNAME, WriteGroups.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteItems }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "createItems")
    public JAXBElement<WriteItems> createCreateItems(WriteItems value) {
        return new JAXBElement<WriteItems>(_CreateItems_QNAME, WriteItems.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WSException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "WSException")
    public JAXBElement<WSException> createWSException(WSException value) {
        return new JAXBElement<WSException>(_WSException_QNAME, WSException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteGroups }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "updateGroups")
    public JAXBElement<WriteGroups> createUpdateGroups(WriteGroups value) {
        return new JAXBElement<WriteGroups>(_UpdateGroups_QNAME, WriteGroups.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteCategories }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "createCategories")
    public JAXBElement<WriteCategories> createCreateCategories(WriteCategories value) {
        return new JAXBElement<WriteCategories>(_CreateCategories_QNAME, WriteCategories.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssetsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "updateAssetsResponse")
    public JAXBElement<AssetsResponse> createUpdateAssetsResponse(AssetsResponse value) {
        return new JAXBElement<AssetsResponse>(_UpdateAssetsResponse_QNAME, AssetsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCategoriesByIdKey }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "getCategoriesByIdKey")
    public JAXBElement<GetCategoriesByIdKey> createGetCategoriesByIdKey(GetCategoriesByIdKey value) {
        return new JAXBElement<GetCategoriesByIdKey>(_GetCategoriesByIdKey_QNAME, GetCategoriesByIdKey.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCategoriesByCategoryId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "getCategoriesByCategoryId")
    public JAXBElement<GetCategoriesByCategoryId> createGetCategoriesByCategoryId(GetCategoriesByCategoryId value) {
        return new JAXBElement<GetCategoriesByCategoryId>(_GetCategoriesByCategoryId_QNAME, GetCategoriesByCategoryId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GroupsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "updateGroupsResponse")
    public JAXBElement<GroupsResponse> createUpdateGroupsResponse(GroupsResponse value) {
        return new JAXBElement<GroupsResponse>(_UpdateGroupsResponse_QNAME, GroupsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteItems }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "deleteItems")
    public JAXBElement<DeleteItems> createDeleteItems(DeleteItems value) {
        return new JAXBElement<DeleteItems>(_DeleteItems_QNAME, DeleteItems.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssetsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "createAssetsResponse")
    public JAXBElement<AssetsResponse> createCreateAssetsResponse(AssetsResponse value) {
        return new JAXBElement<AssetsResponse>(_CreateAssetsResponse_QNAME, AssetsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "getCategoriesResponse")
    public JAXBElement<CategoriesResponse> createGetCategoriesResponse(CategoriesResponse value) {
        return new JAXBElement<CategoriesResponse>(_GetCategoriesResponse_QNAME, CategoriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAssetsByExternalAssetId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "getAssetsByExternalAssetId")
    public JAXBElement<GetAssetsByExternalAssetId> createGetAssetsByExternalAssetId(GetAssetsByExternalAssetId value) {
        return new JAXBElement<GetAssetsByExternalAssetId>(_GetAssetsByExternalAssetId_QNAME, GetAssetsByExternalAssetId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.drutt.com/msdp/media/management/v3", name = "deleteCategoriesResponse")
    public JAXBElement<EmptyResponse> createDeleteCategoriesResponse(EmptyResponse value) {
        return new JAXBElement<EmptyResponse>(_DeleteCategoriesResponse_QNAME, EmptyResponse.class, null, value);
    }

}
