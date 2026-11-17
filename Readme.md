# MICRO COMMERCE

## pour lancer le projet

- ouvrir 4 terminaux.
- dans le premier, lancer la commande

  ```bash
  ./mvnw -pl product spring-boot:run
  ```

- dans le deuxieme, lancer la commande

  ```bash
  ./mvnw -pl inventory spring-boot:run
  ```

- dans le troisième, lancer la commande

  ```bash
  ./mvnw -pl order spring-boot:run
  ```

- dans le quatrième, lancer la commande

  ```bash
  ./mvnw -pl gateway spring-boot:run
  ```

- ensuite, ouvrir bruno et ouvrir une collection. Selectionner le dossier /bruno à la racine du projet
- Les tests sont à lancer dans l'ordre.
- le premier test donnera l'id du produit. Copier le ProductId et le coller dans le fichier /bruno/collection.bru comme valeur de la propriété 'productId'
