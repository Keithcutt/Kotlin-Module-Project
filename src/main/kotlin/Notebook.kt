class Notebook {
    private var listOfArchives: MutableList<DataContainer> = mutableListOf(CreateArchive, Exit)

    fun onStart(){
        println("Приложение запускается...")
        runMenu()
        println("Приложение завершает свою работу")
    }

    private fun createArchive() {
        println("Введите название для вашего архива")
        val nameOfNewArchive: String = InputHandler().textInput()
        val newArchivePosition: Int = listOfArchives.size - 1
        listOfArchives.add(newArchivePosition, Archive(nameOfNewArchive, mutableListOf(CreateNote, Exit)))
        return
    }

    private fun createNote(notes: MutableList<DataContainer>) {
        println("Введите название для вашей заметки")
        val nameOfNewNote: String = InputHandler().textInput()
        println("Введите текст вашей заметки")
        val textOfNewNote: String = InputHandler().textInput()
        val newNotePosition: Int = notes.size - 1
        notes.add(newNotePosition, Note(nameOfNewNote, textOfNewNote))
    }

    private fun isOnTheScreen(list: MutableList<DataContainer>, selected: Int): Boolean {
        val exitOption = list.size - 1
        return if (selected !in 0..exitOption) {
            println("Пункта с таким номером нет на экране\nВведите другое число")
            true
        } else false
    }

    private fun runMenu() {
        var isRunning = true
        while (isRunning) {
            Menu(listOfArchives) {}.printMenu("Список архивов:")

            val selectedNumber = InputHandler().menuOptionSelect()
            if (isOnTheScreen((listOfArchives), selectedNumber))  {
                continue
            }

            Menu(listOfArchives) { dataContainer ->
                when (dataContainer) {
                    CreateArchive -> createArchive()
                    Exit -> isRunning = false

                    is Archive -> {
                        var notesAreRunning = true
                        while (notesAreRunning) {
                            val notes = dataContainer.listOfNotes
                            Menu(notes){}.printMenu("Список заметок:")

                            val notesSelectedNumber = InputHandler().menuOptionSelect()
                            if (isOnTheScreen((notes), notesSelectedNumber))  {
                                continue
                            }

                            Menu(notes){note ->
                                when (note) {
                                    CreateNote -> createNote(notes)
                                    Exit -> notesAreRunning = false

                                    is Note -> {
                                        println(note.name)
                                        println(note.text)
                                        println()
                                    }
                                }
                            }.select(notesSelectedNumber)
                        }
                    }
                }
            }.select(selectedNumber)
        }
    }
}