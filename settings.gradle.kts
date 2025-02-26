rootProject.name = "Sudoku"
include("src:main:model")
findProject(":src:main:model")?.name = "model"
include("test")
include("src:main:controller")
findProject(":src:main:controller")?.name = "controller"
include("src:main:view")
findProject(":src:main:view")?.name = "view"
