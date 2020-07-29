import React from 'react';
import {List, Datagrid, TextField, DeleteButton, 
        ArrayField, SingleFieldList,ChipField, 
        UrlField, Create, SimpleForm, TextInput,
        NumberInput, ArrayInput, SimpleFormIterator, 
        Edit} from 'react-admin';


const redirect = (basePath, id, data) => `/filme`;

export const ListarFilme = props => (

  <List {...props}>
    <Datagrid rowClick="edit">
    <TextField source="titulo" />
    <TextField source="diretor" />
    <UrlField target="_blank"source="perfilImdb" label= "Perfil do IMDb"/>
    <TextField source="anoLancamento" label="Ano de lançamento"/>
    
    <ArrayField source="categorias">
      <SingleFieldList>
        <ChipField source="categoriaFilme"/>
      </SingleFieldList>
    </ArrayField>
    <DeleteButton/>
    </Datagrid>
  </List>

);

export const CriarFilme = props => (

  <Create {...props}>
      <SimpleForm redirect={redirect} submitOnEnter={true}>
        <TextInput source="titulo" label="Titulo do Filme"/>
        <TextInput source="diretor" label="Diretor do Filme"/>
        <TextInput source="perfilImdb" label="Perfil do IMDb"/>
        <NumberInput source="anoLancamento" label="Ano de lançamento"/>

        


        <ArrayInput source="categorias">
        <SimpleFormIterator>
          <TextInput source="categoriaFilme" label="Categoria do Filme"/>
        </SimpleFormIterator> 
        </ArrayInput>

        {/*<ReferenceInput source="categorias" reference="categorias">
        <SelectInput optionText="categoriaFilme"/>
        </ReferenceInput>*/}
      </SimpleForm>
  </Create>
);

export const EditarFilme = props => (

  <Edit {...props}>
    <SimpleForm>
      <TextInput disabled source="id" label="ID"/>
      <TextInput source="titulo" label="Titulo do Filme"/>
      <TextInput source="diretor" label = "Diretor do Filme"/>
      <TextInput source="perfilImdb" label="Perfil do IMDb"/>
        <NumberInput source="anoLancamento" label="Ano de lançamento"/>

        <ArrayInput source="categorias">
        <SimpleFormIterator>
          <TextInput source="categoriaFilme" label="Categoria do Filme"/>
        </SimpleFormIterator> 
        </ArrayInput>
      </SimpleForm>
  </Edit>
);



