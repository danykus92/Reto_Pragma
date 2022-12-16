#language: es
Característica: Buscar producto
  Yo como cliente del my store
  Necesito realizar la busqueda de un producto en el portal web
  Para adicionarlo al carritto de compra

  Esquema del escenario: Validar que un cliente pueda agregar un producto al carrito de compras
    Dado el cliente ingresa al portal de compras de my store
    Cuando el cliente agrega al carrito de compras el producto buscado
      | desde    | nombreDelProducto           | precio | precioTotal |
      | <desde>  | <nombreDelProducto>         | <precio> | <precioTotal> |

    Entonces el cliente podra visualizar los datos del producto en el carrito de compras
 Ejemplos:
   | desde    | nombreDelProducto           | precio | precioTotal |
   | detalle  | Printed Chiffon Dress       | $16.40 | $18.40      |
   | busqueda | Faded Short Sleeve T-shirts | $16.51 | $18.51      |