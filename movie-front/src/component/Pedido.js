import React from "react";
import {List, Datagrid, TextField,  
        Create, Edit, SimpleForm, TextInput,
        ArrayField, SingleFieldList, ChipField,
        ArrayInput, SimpleFormIterator, DeleteButton} from "react-admin";

export const ListarPedido = props => (
  <List {...props}>
    <Datagrid rowClick="edit">
      <TextField reference source="id" label= "ID"/>
      <TextField source="dataPedido" label= "Data do Pedido"/>
      <TextField source="horaPedido" label= "Hora do Pedido"/>
      <TextField source="descricao" label= "Descrição do Pedido"/>
      <ArrayField source="filmes">
        <SingleFieldList>
          <ChipField  source="titulo" label="Filmes"/>
        </SingleFieldList>
      </ArrayField>
      <DeleteButton/>
    </Datagrid>
  </List>

);

export const CriarPedido = props => (

  <Create {...props}>
    <SimpleForm submitOnEnter={true}>
      <TextInput source="dataPedido" label="Data do Pedido"/>
      <TextInput source="horaPedido" label="Hora do Pedido"/>
      <TextInput source="descricao" label="Descrição"/>
      <ArrayInput source="filme">
        <SimpleFormIterator>
          <TextInput source="titulo" label="Titulo do Filme"/>
          <TextInput source="diretor" label="Diretor do Filme"/>
          <TextInput source="imdbPerfil" label="Link do IMDb"/>
          <TextInput source="anolancamento" label="Ano de Lançamento"/>
        </SimpleFormIterator> 
        </ArrayInput>
    </SimpleForm>
  </Create>
  
);

export const EditarPedido = props => (

  <Edit {...props}>
    <SimpleForm submitOnEnter={true}>
      <TextInput disabled source="id" label="ID"/>
      <TextInput source="dataPedido" label="Data do Pedido"/>
      <TextInput source="horaPedido" label="Hora do Pedido"/>
      <TextInput source="descricao" label="Descrição"/>
      <ArrayInput source="filme">
        <SimpleFormIterator>
          <TextInput source="titulo" label="Titulo do Filme"/>
          <TextInput source="diretor" label="Diretor do Filme"/>
          <TextInput source="imdbPerfil" label="Link do IMDb"/>
          <TextInput source="anolancamento" label="Ano de Lançamento"/>
        </SimpleFormIterator> 
        </ArrayInput>
    </SimpleForm>
  </Edit>
);