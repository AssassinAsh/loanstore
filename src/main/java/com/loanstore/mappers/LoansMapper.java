package com.loanstore.mappers;

import com.loanstore.bos.LoansBo;
import com.loanstore.dtos.LoanRequestDto;
import com.loanstore.entities.LoansEntity;
import com.loanstore.utils.DateUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Date;

@Mapper(componentModel = "spring")
public interface LoansMapper {

    LoansEntity boToEntity(LoansBo bo);

    @Mapping(source = "paymentDate", target = "paymentDate", qualifiedByName = "getDate")
    @Mapping(source = "dueDate", target = "dueDate", qualifiedByName = "getDate")
    LoansBo dtoToBo(LoanRequestDto dto);

    @Named(value = "getDate")
    default Date getDateFromString(String date) throws Exception {
        return DateUtils.getDateFromString(date, "dd-mm-yyyy");
    }
}
