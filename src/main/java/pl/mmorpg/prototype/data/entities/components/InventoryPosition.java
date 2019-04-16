package pl.mmorpg.prototype.data.entities.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class InventoryPosition
{
	@Column(name = "inventory_page_number")
	private Integer inventoryPageNumber;

	@Column(name = "inventory_x")
	private Integer inventoryX;

	@Column(name = "inventory_y")
	private Integer inventoryY;
}
