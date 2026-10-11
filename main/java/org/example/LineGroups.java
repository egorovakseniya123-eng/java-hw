package org.example;

import java.util.ArrayList;
import java.util.List;

//список групп прямых
public class LineGroups {
    public static List<List<Line3D>> groupParallel3D(List<Line3D> lines) {
        List<List<Line3D>> groups = new ArrayList<>();
        boolean[] used = new boolean[lines.size()];

        for (int i = 0; i < lines.size(); i++) {
            if (used[i]) continue;

            List<Line3D> group = new ArrayList<>();
            group.add(lines.get(i));
            used[i] = true;

            for (int j = i + 1; j < lines.size(); j++) {
                if (used[j]) continue;
                if (lines.get(i).isParallel(lines.get(j))) {
                    group.add(lines.get(j));
                    used[j] = true;
                }
            }
            groups.add(group);
        }
        return groups;
    }

    public static List<List<Line2D>> groupParallel2D(List<Line2D> lines) {
        List<List<Line2D>> groups = new ArrayList<>();
        boolean[] used = new boolean[lines.size()];

        for (int i = 0; i < lines.size(); i++) {
            if (used[i]) continue;

            List<Line2D> group = new ArrayList<>();
            group.add(lines.get(i));
            used[i] = true;

            for (int j = i + 1; j < lines.size(); j++) {
                if (used[j]) continue;
                if (lines.get(i).isParallel(lines.get(j))) {
                    group.add(lines.get(j));
                    used[j] = true;
                }
            }
            groups.add(group);
        }
        return groups;
    }
}
