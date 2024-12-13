package com.palmen.supermarket.controller;

import java.util.List;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.palmen.supermarket.dto.StoreDTO;
import com.palmen.supermarket.input.StoreInput;
import com.palmen.supermarket.mapper.IStoreMapper;
import com.palmen.supermarket.service.IStoreService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StoreController {

	private final IStoreService storeService;
	private final IStoreMapper storeMapper;

	@MutationMapping
	public Boolean createStore(@Argument("storeInput") StoreInput storeInput) {
		return storeService.createStore(storeMapper.storeInputToStoreDTO(storeInput));
	}

	@MutationMapping
	public Boolean deleteStore(@Argument("id") Long id) {
		return storeService.deleteStore(id);
	}

	@QueryMapping
	public StoreDTO findStore(@Argument("id") Long id) {
		return storeService.findStore(id);
	}

	@QueryMapping
	public List<StoreDTO> findAllStores() {
		return storeService.findAllStores();
	}

}
