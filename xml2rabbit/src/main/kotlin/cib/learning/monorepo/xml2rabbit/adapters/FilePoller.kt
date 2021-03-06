package cib.learning.monorepo.xml2rabbit.adapters

import org.springframework.integration.file.FileReadingMessageSource
import org.springframework.integration.file.filters.FileListFilter
import java.io.File

class FilePoller : FileReadingMessageSource() {

    fun get( directory:File, filter:FileListFilter<File>) {
        super.setDirectory(directory)
        super.setFilter(filter)
    }
}