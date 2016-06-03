package com.squirrel_explorer.eagleeye.lint.rules.defect.lang;

import com.android.annotations.NonNull;
import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;

import lombok.ast.AstVisitor;

/**
 * Created by squirrel-explorer on 16/3/27.
 */
public class ConcurrentModificationDetector extends Detector implements Detector.JavaScanner {
    public static final Issue ISSUE = Issue.create(
            "ConcurrentModificationDetector",
            "Use constants instead of enums",
            "This app should use constants instead of enums.",
            Category.PERFORMANCE,
            2,
            Severity.WARNING,
            new Implementation(
                    ConcurrentModificationDetector.class,
                    Scope.JAVA_FILE_SCOPE));

    @Override
    public AstVisitor createJavaVisitor(@NonNull JavaContext context) {
        return new ConcurrentModificationAstVisitor(context);
    }
}
