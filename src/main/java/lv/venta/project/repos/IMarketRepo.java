package lv.venta.project.repos;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.project.models.GameType;
import lv.venta.project.models.Item;
import lv.venta.project.models.Market;

@Repository
public interface IMarketRepo extends CrudRepository<Market, Integer>, JpaSpecificationExecutor<Item> {

	public boolean existsByGameType(GameType gameType);
}

