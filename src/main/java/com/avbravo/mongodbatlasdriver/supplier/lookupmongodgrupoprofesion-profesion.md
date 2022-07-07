***
# Referencia de primer nivel
Es invocacion directa a la coleccion padre.
## profesion-grupoprofesion
```json
db.profesion.aggregate(
[  
   {
    $lookup:{
            from:"grupoprofesion",
            localField:"grupoprofesion.idgrupoprofesion",
            foreignField:"idgrupoprofesion",
            as:"grupoprofesion"
            }
    }
]
).pretty()
```
