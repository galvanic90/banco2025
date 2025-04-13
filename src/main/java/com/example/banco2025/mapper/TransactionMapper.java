package com.example.banco2025.mapper;

import com.example.banco2025.DTO.TransactionDTO;
import com.example.banco2025.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);
    TransactionDTO transactionToTransactionDTO(Transaction transaction);
}
