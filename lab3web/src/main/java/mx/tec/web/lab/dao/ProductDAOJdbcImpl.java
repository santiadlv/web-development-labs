/*
 * ProductDAOJdbcImpl
 * Version 1.0
 * August 21, 2021 
 * Copyright 2021 Tecnologico de Monterrey
 */
package mx.tec.web.lab.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import mx.tec.web.lab.service.CommentsService;
import mx.tec.web.lab.vo.ProductVO;
import mx.tec.web.lab.vo.SkuVO;

/**
 * @author Enrique Sanchez
 *
 */
@Component("jdbc")
public class ProductDAOJdbcImpl implements ProductDAO {
	/** Id field **/
	public static final String ID = "id";
	
	/** Name field **/
	public static final String NAME = "name";
	
	/** Description field **/
	public static final String DESCRIPTION = "description";
	
	/** ChildSku color field **/
	public static final String COLOR = "color";
	
	/** ChildSku size field **/
	public static final String SIZE = "size";
	
	/** ChildSku list price field **/
	public static final String LISTPRICE = "listPrice";
	
	/** ChildSku sale price field **/
	public static final String SALEPRICE = "salePrice";
	
	/** ChildSku quantity on hand field **/
	public static final String QUANTITYONHAND = "quantityOnHand";

	/** ChildSku small image URL field **/
	public static final String SMALLIMAGEURL = "smallImageUrl";
	
	/** ChildSku medium image URL field **/
	public static final String MEDIUMIMAGEURL = "mediumImageUrl";
	
	/** ChildSku large image URL field **/
	public static final String LARGEIMAGEURL = "largeImageUrl";
	
	/** SQL string to retrieve Sku's **/
	public static final String SKUSQL = "SELECT id,color,size,listPrice,salePrice,quantityOnHand,smallImageUrl,mediumImageUrl,largeImageUrl from Sku where parentProduct_id = ?";
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	CommentsService commentService;
	
	@Override
	public List<ProductVO> findAll() {
		String sql = "SELECT id, name, description FROM Product";

		return jdbcTemplate.query(sql, (ResultSet rs) -> {
			List<ProductVO> list = new ArrayList<>();

			while(rs.next()){
				List<SkuVO> childSkus = new ArrayList<>();
				jdbcTemplate.query(SKUSQL, new Object[] {rs.getLong(ID)}, new int[] {java.sql.Types.INTEGER},
						(ResultSet rsSku) -> {
							while(rsSku.next()) {
								SkuVO sku = new SkuVO(rsSku.getLong(ID), 
													  rsSku.getString(COLOR), 
													  rsSku.getString(SIZE),
													  rsSku.getDouble(LISTPRICE), 
													  rsSku.getDouble(SALEPRICE),
													  rsSku.getLong(QUANTITYONHAND), 
													  rsSku.getString(SMALLIMAGEURL),
													  rsSku.getString(MEDIUMIMAGEURL),
													  rsSku.getString(LARGEIMAGEURL)
													 );
								childSkus.add(sku);
							}
						});
				
				ProductVO product = new ProductVO(
					rs.getLong(ID),
					rs.getString(NAME), 
					rs.getString(DESCRIPTION), 
					childSkus,
					commentService.getComments()
				);

				list.add(product);
			}
			
			return list;
		});
	}

	@Override
	public Optional<ProductVO> findById(long id) {
        String sql = "SELECT id, name, description FROM Product WHERE id = ?";
        
		return jdbcTemplate.query(sql, new Object[]{id}, new int[]{java.sql.Types.INTEGER}, (ResultSet rs) -> {
			Optional<ProductVO> optionalProduct = Optional.empty();

			if(rs.next()){
				List<SkuVO> childSkus = new ArrayList<>();
				jdbcTemplate.query(SKUSQL, new Object[] {rs.getLong(ID)}, new int[] {java.sql.Types.INTEGER},
						(ResultSet rsSku) -> {
							while(rsSku.next()) {
								SkuVO sku = new SkuVO(rsSku.getLong(ID), 
													  rsSku.getString(COLOR), 
													  rsSku.getString(SIZE),
													  rsSku.getDouble(LISTPRICE), 
													  rsSku.getDouble(SALEPRICE),
													  rsSku.getLong(QUANTITYONHAND), 
													  rsSku.getString(SMALLIMAGEURL),
													  rsSku.getString(MEDIUMIMAGEURL),
													  rsSku.getString(LARGEIMAGEURL)
													 );
								childSkus.add(sku);
							}
						});
				
				ProductVO product = new ProductVO(
					rs.getLong(ID),
					rs.getString(NAME), 
					rs.getString(DESCRIPTION),
					childSkus,
					commentService.getComments()
				);
				
				optionalProduct = Optional.of(product);
			}
			
			return optionalProduct;
		});
	}

	@Override
	public List<ProductVO> findByNameLike(String pattern) {
		String sql = "SELECT id, name, description FROM Product WHERE name like ?";

		return jdbcTemplate.query(sql, new Object[]{"%" + pattern + "%"}, new int[]{java.sql.Types.VARCHAR}, (ResultSet rs) -> {
			List<ProductVO> list = new ArrayList<>();

			while(rs.next()){
				List<SkuVO> childSkus = new ArrayList<>();
				jdbcTemplate.query(SKUSQL, new Object[] {rs.getLong(ID)}, new int[] {java.sql.Types.INTEGER},
						(ResultSet rsSku) -> {
							while(rsSku.next()) {
								SkuVO sku = new SkuVO(rsSku.getLong(ID), 
													  rsSku.getString(COLOR), 
													  rsSku.getString(SIZE),
													  rsSku.getDouble(LISTPRICE), 
													  rsSku.getDouble(SALEPRICE),
													  rsSku.getLong(QUANTITYONHAND), 
													  rsSku.getString(SMALLIMAGEURL),
													  rsSku.getString(MEDIUMIMAGEURL),
													  rsSku.getString(LARGEIMAGEURL)
													 );
								childSkus.add(sku);
							}
						});
				
				ProductVO product = new ProductVO(
					rs.getLong(ID),
					rs.getString(NAME), 
					rs.getString(DESCRIPTION), 
					new ArrayList<>(),
					commentService.getComments()
				);
				
				list.add(product);
			}
			
			return list;
		});
	}

	@Override
	public ProductVO insert(ProductVO newProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(ProductVO existingProduct) {
		String skuSql = "DELETE FROM Sku WHERE parentProduct_id=?";
		this.jdbcTemplate.update(skuSql, new Object[] {existingProduct.getId()}, new int[] {java.sql.Types.INTEGER});
		
		String productSql = "DELETE FROM Product WHERE id=?";
		this.jdbcTemplate.update(productSql, new Object[] {existingProduct.getId()}, new int[] {java.sql.Types.INTEGER});
	}

	@Override
	public void update(ProductVO existingProduct) {
		// TODO Auto-generated method stub

	}

}
