package lv.venta.project.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.project.models.Market;

public interface IMarketRepo extends CrudRepository<Market, Integer> {

}
