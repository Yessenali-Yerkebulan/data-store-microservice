package com.example.datastoremicroservice.web.mapper;

import org.mapstruct.Mapper;

import com.example.datastoremicroservice.model.Summary;
import com.example.datastoremicroservice.web.dto.SummaryDto;

@Mapper(componentModel = "spring")
public interface SummaryMapper extends Mappable<Summary, SummaryDto>{
}
