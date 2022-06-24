package lv.venta.project.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import lv.venta.project.models.GameType;
import lv.venta.project.models.Item;
import lv.venta.project.models.Market;

public interface IMarketRepo extends JpaRepository<Market, Integer>, JpaSpecificationExecutor<Item> {

	public boolean existsByGameType(GameType gameType);
}

