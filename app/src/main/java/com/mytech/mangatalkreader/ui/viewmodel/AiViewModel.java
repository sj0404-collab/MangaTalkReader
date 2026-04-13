package com.mytech.mangatalkreader.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewModelScope;
import com.mytech.mangatalkreader.ai.ImagePreprocessor;
import com.mytech.mangatalkreader.data.db.dao.TextBlockDao;
import com.mytech.mangatalkreader.data.db.entity.TextBlockEntity;
import dagger.hilt.android.lifecycle.HiltViewModel;
import java.util.List;
import javax.inject.Inject;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.launch;

@HiltViewModel
public final class AiViewModel extends ViewModel {
    private final TextBlockDao textBlockDao;
    private final ImagePreprocessor imagePreprocessor;
    private final MutableStateFlow<Boolean> isProcessing = new MutableStateFlow<>(false);
    private final MutableStateFlow<String> recognizedText = new MutableStateFlow<>("");

    @Inject
    public AiViewModel(TextBlockDao textBlockDao) {
        this.textBlockDao = textBlockDao;
        this.imagePreprocessor = ImagePreprocessor.INSTANCE;
    }

    public StateFlow<Boolean> getIsProcessing() {
        return isProcessing;
    }

    public StateFlow<String> getRecognizedText() {
        return recognizedText;
    }

    public void processImage(long chapterId, int pageNumber) {
        viewModelScope.launch(kotlinx.coroutines.Dispatchers.getIO(), 0, (coroutine, continuation) -> {
            isProcessing.setValue(true);
            List<TextBlockEntity> textBlocks = textBlockDao.getTextBlocks(chapterId, pageNumber).getValue();
            StringBuilder sb = new StringBuilder();
            if (textBlocks != null) {
                for (TextBlockEntity block : textBlocks) {
                    sb.append(block.getText()).append("\n");
                }
            }
            recognizedText.setValue(sb.toString());
            isProcessing.setValue(false);
            return null;
        });
    }
}
